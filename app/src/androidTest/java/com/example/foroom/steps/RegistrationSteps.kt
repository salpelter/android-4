package com.example.foroom.steps

import com.example.foroom.helper.tap
import com.example.foroom.helper.typeText
import com.example.foroom.pageMatchers.LoginPageMatchers
import com.example.foroom.pageMatchers.LoginPageMatchers.passwordField
import com.example.foroom.pageMatchers.LoginPageMatchers.userNameField
import com.example.foroom.pageMatchers.RegistrationPageMatchers

class RegistrationSteps {
    fun enterUserName (userName: String): RegistrationSteps {
        with(RegistrationPageMatchers) {
            userNameField.typeText(userName)
        }
        return this
    }

    fun enterPassword(password: String): RegistrationSteps {
        with(RegistrationPageMatchers) {
            passwordField.typeText(password)
        }
        return this
    }

    fun repeatPassword(password: String): RegistrationSteps {
        with(RegistrationPageMatchers) {
            repeatPasswordField.typeText(password)
        }
        return this
    }

    fun clickOnRegistrationButton(): RegistrationSteps {
        with(RegistrationPageMatchers) {
            registrationButton.tap()
        }
        return this
    }
}