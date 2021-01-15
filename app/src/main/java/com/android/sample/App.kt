package com.android.sample

import android.app.Application
import com.android.sample.core.SessionManagerImpl

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SessionManagerImpl().initialize(this).setUser("test", "123")
    }
}