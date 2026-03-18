package com.example.foroom.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChangeLanguageTest : BaseTest() {
    @Test
    fun changeLanguageScenario() {
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

        // change language to english
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