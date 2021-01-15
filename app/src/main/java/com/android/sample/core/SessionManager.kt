package com.android.sample.core

import android.content.Context

interface SessionManager {
    fun initialize(context: Context): SessionManager
    fun setUser(name: String, pass: String)
    fun login(name: String, pass: String):Boolean
}