package fr.legrand.daifen.application.data.manager.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.legrand.daifen.application.data.exception.AuthenticationException
import fr.legrand.daifen.application.data.manager.prefs.SharedPrefsManager
import okhttp3.Interceptor
import okhttp3.Response

private const val COOKIE_HEADER_NAME = "set-cookie"

class NetworkInterceptor(private val sharedPrefsManager: SharedPrefsManager, private val gson: Gson) : Interceptor {
    private val typeToken = object : TypeToken<MutableMap<String, String>>() {}.type

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val authCookieMap = sharedPrefsManager.getAuthCookie()?.let {
            gson.fromJson<MutableMap<String, String>>(it, typeToken)
        } ?: mutableMapOf()
        //TODO handle cookie
        val newCookie =
            response.headers().toMultimap()[COOKIE_HEADER_NAME]?.mapWithNext() ?: throw AuthenticationException()
        authCookieMap.putAll(newCookie)
        sharedPrefsManager.setAuthCookie(gson.toJson(authCookieMap))
        return response
    }

}

private fun MutableList<String>.mapWithNext(): Map<String, String> {
    val map = mutableMapOf<String, String>()
    for (i in 0 until size - 1 step 2) {
        map[get(i)] = get(i + 1)
    }
    return map
}
