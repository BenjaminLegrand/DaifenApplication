package fr.legrand.daifen.application.data.utils

import com.google.gson.Gson

inline fun <reified T> Gson.fromJson(json: String): T = this.fromJson(json, T::class.java)