package com.example.foroom.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants.PASSWORD
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChangeLanguageTest : BaseTest() {
    @Test
    fun changeLanguageScenario() {
        // log in
        loginSteps
            .enterUserName(username)
            .enterPassword(PASSWORD)

        commonSteps
            .closeKeyboard()

        loginSteps
            .tapOnLoginButton()

        // change language to english
        navBarSteps
            .tapOnProfileButton()

        profileSteps
            .tapOnChangeLanguageButton()
            .tapOnEnglishLanguageButton()

        profileSteps
            .verifyLanguageChangedToEnglish()

        // back to georgian
        profileSteps
            .tapOnChangeLanguageButton()
            .tapOnGeorgianLanguageButton()

        profileSteps
            .verifyLanguageChangedToGeorgian()
    }
}