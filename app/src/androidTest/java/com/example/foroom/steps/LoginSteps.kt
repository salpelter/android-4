package com.example.foroom.steps

import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.tap
import com.example.foroom.utils.typeText
import com.example.foroom.utils.waitForViewVisible
import com.example.foroom.pages.LoginPageMatchers
import org.junit.Assert

class LoginSteps {
    fun enterUserName(userName: String): LoginSteps {
        with(LoginPageMatchers) {
            logInButton.waitForViewVisible(10)
            userNameField.typeText(userName, 10)
        }
        return this
    }

    fun enterPassword(password: String): LoginSteps {
        with(LoginPageMatchers) {
            logInButton.waitForViewVisible(10)
            passwordField.typeText(password, 10)
        }
        return this
    }

    fun tapOnLoginButton(): LoginSteps {
        with(LoginPageMatchers) {
            logInButton.tap()
        }
        return this
    }

    fun tapOnRegistrationButton(): LoginSteps {
        with(LoginPageMatchers) {
            registrationButton.tap()
        }
        return this
    }

    fun verifyInvalidPasswordMessageVisibility(): LoginSteps {
        with(LoginPageMatchers) {
            Assert.assertTrue(invalidPasswordMessage.isViewDisplayed())
        }
        return this
    }

    fun verifyNonExistentUserNameMessageVisibility(): LoginSteps {
        with(LoginPageMatchers) {
            Assert.assertTrue(nonExistentUserNameMessage.isViewDisplayed())
        }
        return this
    }
}