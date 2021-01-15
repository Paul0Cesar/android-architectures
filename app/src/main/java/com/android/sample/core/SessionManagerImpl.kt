package com.android.sample.core

import android.content.Context
import android.content.SharedPreferences

class SessionManagerImpl : SessionManager {

    companion object {
        private const val PREF_NAME = "mpvAppTest"
        private var application: Context? = null
        private lateinit var prefs: SharedPreferences
    }

    override fun initialize(context: Context): SessionManager {
        if (application == null) {
            application = context
            application?.let {
                prefs = it.getSharedPreferences(
                    PREF_NAME,
                    Context.MODE_PRIVATE
                )
            }
        }
        return this
    }

    override fun setUser(name: String, pass: String) {
        prefs.edit().apply {
            putString("name", name)
            putString("pass", pass)
        }.apply()
    }

    override fun login(name: String, pass: String): Boolean {
        val nameSave = prefs.getString("name", null)
        val passSave = prefs.getString("pass", null)
        return (name == nameSave && pass == passSave)
    }
}