package com.android.sample.ui.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.sample.R
import com.android.sample.core.SessionManagerImpl
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginViewable {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this, SessionManagerImpl())
        init()
    }

    private fun init() {
        login.setOnClickListener {
            presenter.login(username.text.toString(), password.text.toString())
        }
    }

    override fun loginSuccess() {
        Toast.makeText(this, R.string.welcome, Toast.LENGTH_LONG).show()
    }

    override fun showError() {
        Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show()
    }
}