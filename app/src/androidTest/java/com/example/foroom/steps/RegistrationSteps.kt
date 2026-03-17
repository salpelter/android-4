package com.example.foroom.steps

import com.example.foroom.utils.tap
import com.example.foroom.utils.typeText
import com.example.foroom.pages.RegistrationPageMatchers

class RegistrationSteps {
    fun enterUserName(userName: String): RegistrationSteps {
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

    fun tapOnRegistrationButton(): RegistrationSteps {
        with(RegistrationPageMatchers) {
            registrationButton.tap()
        }
        return this
    }
}