package com.android.sample

import com.android.sample.core.SessionManager
import com.android.sample.ui.login.LoginPresenter
import com.android.sample.ui.login.LoginViewable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    data class User(var name: String, var password: String)

    companion object {
        private val ENABLED_USER: User = User("valid", "123")
        private val INVALID_USER: User = User("invalid", "1234")
    }

    @Mock
    private lateinit var view: LoginViewable

    @Mock
    private lateinit var sessionManager: SessionManager
    private lateinit var presenter: LoginPresenter


    @Before
    fun setup() {
        presenter = LoginPresenter(
            view,
            sessionManager
        )
    }

    @Test
    fun success_login() {
        //when
        Mockito.`when`(sessionManager.login(ENABLED_USER.name, ENABLED_USER.password))
            .thenReturn(true)
        presenter.login(ENABLED_USER.name, ENABLED_USER.password)

        // Then
        Mockito.verify(view).loginSuccess()
    }


    @Test
    fun login_fail() {
        //when
        Mockito.`when`(sessionManager.login(INVALID_USER.name, INVALID_USER.password))
            .thenReturn(false)
        presenter.login(INVALID_USER.name, INVALID_USER.password)

        // Then
        Mockito.verify(view).showError()
    }
}