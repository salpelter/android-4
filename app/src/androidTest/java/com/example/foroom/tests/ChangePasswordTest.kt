package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants.PASSWORD
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.CommonSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.NavBarSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import com.example.foroom.utils.RandomUsernameGenerator.Companion.getRandomUsername
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
class ChangePasswordTest : BaseTest() {
    @Test
    fun changePasswordScenario() {
        // log in
        loginSteps
            .enterUserName(username)
            .enterPassword(PASSWORD)

        commonSteps
            .closeKeyboard()

        loginSteps
            .tapOnLoginButton()

        // go to profile page
        navBarSteps
            .tapOnProfileButton()

        // change password
        profileSteps
            .tapOnChangePasswordButton()
            .enterNewPassword(PASSWORD + PASSWORD)
            .repeatNewPassword(PASSWORD + PASSWORD)

        commonSteps
            .closeKeyboard()

        profileSteps
            .tapOnConfirmChangePasswordButton()

        // check if login with new password successful
        loginSteps
            .enterUserName(username)
            .enterPassword(PASSWORD + PASSWORD)

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