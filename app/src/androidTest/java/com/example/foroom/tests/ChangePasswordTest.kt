package com.example.foroom.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.DataGenerator
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChangePasswordTest : BaseTest() {
    @Test
    fun changePasswordScenario() {
        // log in
        loginSteps
            .enterUserName(username)
            .enterPassword(password)

        commonSteps
            .closeKeyboard()

        loginSteps
            .tapOnLoginButton()

        // go to profile page
        navBarSteps
            .tapOnProfileButton()

        // change password
        val newPassword = DataGenerator.getRandomPassword()

        profileSteps
            .tapOnChangePasswordButton()
            .enterNewPassword(newPassword)
            .repeatNewPassword(newPassword)

        commonSteps
            .closeKeyboard()

        profileSteps
            .tapOnConfirmChangePasswordButton()

        // check if login with new password successful
        loginSteps
            .enterUserName(username)
            .enterPassword(newPassword)

        commonSteps
            .closeKeyboard()

        loginSteps
            .tapOnLoginButton()

        navBarSteps
            .tapOnProfileButton()

        profileSteps
            .verifyCorrectUserLoggedIn(username)
    }
}