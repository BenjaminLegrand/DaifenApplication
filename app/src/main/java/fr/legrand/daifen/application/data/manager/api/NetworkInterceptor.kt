package fr.legrand.daifen.application.data.manager.api

import com.google.gson.Gson
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import fr.legrand.daifen.application.data.utils.fromJson
import okhttp3.Interceptor
import okhttp3.Response

private const val COOKIE_RESPONSE_HEADER_NAME = "set-cookie"
private const val COOKIE_REQUEST_HEADER_NAME = "Cookie"
private const val COOKIE_DATA_SEPARATOR = "="
private val COOKIE_ITEM_SEPARATOR_REGEX = Regex("[;,]\\s*")
private const val COOKIE_ITEM_SEPARATOR = "; "
private val COOKIE_IDENTIFIERS = arrayOf("s", "id", "SERVERID31394", "pass")
private const val HTTP_REDIRECT_CODE = 302
private const val LOCATION_HEADER = "location"
private const val LOCATION_HEADER_LOGIN_VALUE = "/jeu/identification.php"

class NetworkInterceptor(
    private val sharedPrefsManager: SharedPrefsManager,
    private val gson: Gson
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = sharedPrefsManager.getAuthCookie()?.let {
            chain.request().newBuilder().addHeader(
                COOKIE_REQUEST_HEADER_NAME,
                gson.fromJson<MutableMap<String, String>>(it).map { entry -> "${entry.key}$COOKIE_DATA_SEPARATOR${entry.value}" }.joinToString(
                    COOKIE_ITEM_SEPARATOR
                )
            ).build()
        } ?: chain.request()

        val response = chain.proceed(request)

        if(response.code() == HTTP_REDIRECT_CODE && response.header(LOCATION_HEADER) == LOCATION_HEADER_LOGIN_VALUE){
            throw AuthenticationException()
        }

        val authCookieMap = sharedPrefsManager.getAuthCookie()?.let {
            gson.fromJson<MutableMap<String, String>>(it)
        } ?: mutableMapOf()
        val newCookie =
            response.headers().toMultimap()[COOKIE_RESPONSE_HEADER_NAME]?.joinToString()?.split(
                COOKIE_ITEM_SEPARATOR_REGEX
            )?.associate {
                Pair(
                    it.substringBefore(
                        COOKIE_DATA_SEPARATOR
                    ), it.substringAfter(COOKIE_DATA_SEPARATOR)
                )
            }?.filterKeys { it in COOKIE_IDENTIFIERS } ?: emptyMap()
        newCookie.entries.forEach { authCookieMap[it.key] = it.value }
        sharedPrefsManager.setAuthCookie(gson.toJson(authCookieMap))
        return response
    }

}

