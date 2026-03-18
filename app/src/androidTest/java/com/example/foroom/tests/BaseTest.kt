package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.foroom.data.Constants.PASSWORD
import com.example.foroom.pages.ProfilePageMatchers.changeLanguageButton
import com.example.foroom.pages.ProfilePageMatchers.changeLanguageText
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.CommonSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.NavBarSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import com.example.foroom.utils.RandomUsernameGenerator.Companion.getRandomUsername
import com.example.foroom.utils.getText
import org.junit.Before
import org.junit.Rule

open class BaseTest {
    @get:Rule
    val activity = ActivityScenarioRule(ForoomActivity::class.java)

    val commonSteps = CommonSteps()
    val registrationSteps = RegistrationSteps()
    val loginSteps = LoginSteps()
    val navBarSteps = NavBarSteps()
    val profileSteps = ProfileSteps()
    var username = ""

    @Before
    fun setUp() {
        if (navBarSteps.isNavBarVisible()) {
            // in case already logged in for some reason
            navBarSteps
                .tapOnProfileButton()

            // change language to georgian in necessary
            if ((changeLanguageText.getText()) != "ენის შეცვლა") {
                profileSteps
                    .tapOnChangeLanguageButton()
                    .tapOnGeorgianLanguageButton()
                    .verifyLanguageChangedToGeorgian()
            }

            profileSteps
                .tapOnSignOutButton()
        }

        username = getRandomUsername()

        // register
        loginSteps
            .tapOnRegistrationButton()

        registrationSteps
            .enterUserName(username)
            .enterPassword(PASSWORD)
            .repeatPassword(PASSWORD)

        commonSteps
            .closeKeyboard()

        registrationSteps
            .tapOnRegistrationButton()

        // log out to go back to initial state
        navBarSteps
            .tapOnProfileButton()

        profileSteps
            .tapOnSignOutButton()
    }
}