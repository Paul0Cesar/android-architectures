package com.android.sample.ui.login

import com.android.sample.core.SessionManager
import com.android.sample.core.mvp.Presenter

class LoginPresenter(private val view: LoginViewable, private val sessionManager: SessionManager) :
    Presenter() {

    fun login(name: String, pass: String) {
        if (sessionManager.login(name, pass)) {
            view.loginSuccess()
        } else {
            view.showError()
        }
    }
}