package fr.legrand.daifen.application.data.manager.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

private const val AUTH_COOKIE_KEY = "AUTH_COOKIE_KEY"
private const val PIGEON_UPDATE_AUTH_ERROR_RECEIVED_KEY = "PIGEON_UPDATE_AUTH_ERROR_RECEIVED_KEY"
private val DEFAULT_AUTH_COOKIE = null

class SharedPrefsManagerImpl
constructor(context: Context) : SharedPrefsManager {

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    override fun setAuthCookie(authCookie: String) {
        sharedPreferences.edit {
            putString(AUTH_COOKIE_KEY, authCookie)
        }
    }

    override fun onPigeonUpdateAuthErrorReceived() {
        sharedPreferences.edit {
            putBoolean(PIGEON_UPDATE_AUTH_ERROR_RECEIVED_KEY, true)
        }
    }

    override fun getAuthCookie(): String? =
        sharedPreferences.getString(AUTH_COOKIE_KEY, DEFAULT_AUTH_COOKIE)

    override fun resetAuthCookie() {
        sharedPreferences.edit {
            putString(AUTH_COOKIE_KEY, DEFAULT_AUTH_COOKIE)
        }
    }

    override fun getPigeonUpdateAuthErrorReceived() =
        sharedPreferences.getBoolean(PIGEON_UPDATE_AUTH_ERROR_RECEIVED_KEY, false)

    override fun resetPigeonUpdateAuthErrorReceived() {
        sharedPreferences.edit {
            putBoolean(PIGEON_UPDATE_AUTH_ERROR_RECEIVED_KEY, false)
        }
    }
}