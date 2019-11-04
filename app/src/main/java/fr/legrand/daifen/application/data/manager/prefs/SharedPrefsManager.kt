package fr.legrand.daifen.application.data.manager.prefs

interface SharedPrefsManager {
    fun setAuthCookie(authCookie : String)
    fun getAuthCookie() : String?
    fun resetAuthCookie()
    fun onPigeonUpdateAuthErrorReceived()
    fun resetPigeonUpdateAuthErrorReceived()
    fun getPigeonUpdateAuthErrorReceived(): Boolean
}