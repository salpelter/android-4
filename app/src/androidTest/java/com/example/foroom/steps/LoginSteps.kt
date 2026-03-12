package com.example.foroom.steps

import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.tap
import com.example.foroom.utils.typeText
import com.example.foroom.pages.LoginPageMatchers
import org.junit.Assert

class LoginSteps {
    fun enterUserName (userName: String): LoginSteps {
        with(LoginPageMatchers) {
            userNameField.typeText(userName)
        }
        return this
    }

    fun enterPassword(password: String): LoginSteps {
        with(LoginPageMatchers) {
            passwordField.typeText(password)
        }
        return this
    }

    fun clickOnLoginButton(): LoginSteps {
        with(LoginPageMatchers) {
            logInButton.tap()
        }
        return this
    }

    fun clickOnRegistrationButton(): LoginSteps {
        with(LoginPageMatchers) {
            registrationButton.tap()
        }
        return this
    }

    fun verifyInvalidPasswordMessagePresent(): LoginSteps {
        with(LoginPageMatchers) {
            Assert.assertTrue(invalidPasswordMessage.isViewDisplayed())
        }
        return this
    }

    fun verifyNonExistentUserNameMessagePresent(): LoginSteps {
        with(LoginPageMatchers) {
            Assert.assertTrue(nonExistentUserNameMessage.isViewDisplayed())
        }
        return this
    }
}