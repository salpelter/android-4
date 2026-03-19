package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.foroom.pages.ProfilePageMatchers.changeLanguageText
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.steps.CommonSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.NavBarSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import com.example.foroom.data.DataGenerator
import com.example.foroom.steps.ChatSteps
import com.example.foroom.steps.MainSteps
import com.example.foroom.utils.getText
import com.example.foroom.utils.staticWait
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
    val chatSteps = ChatSteps()
    val mainSteps = MainSteps()
    var username = ""
    var password = ""

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

        registerWithRandomCredentials()
        signOut()
    }

    // methods to reduce code duplication
    fun registerWithRandomCredentials() {
        username = "Daniel_" + DataGenerator.getRandomString()
        password = DataGenerator.getRandomPassword()

        loginSteps
            .tapOnRegistrationButton()

        registrationSteps
            .enterUserName(username)
            .enterPassword(password)
            .repeatPassword(password)

        commonSteps
            .closeKeyboard()

        registrationSteps
            .tapOnRegistrationButton()
    }

    fun signOut() {
        navBarSteps
            .tapOnProfileButton()

        profileSteps
            .tapOnSignOutButton()
    }

    fun logIn(userName: String, password: String) {
        loginSteps
            .enterUserName(userName)
            .enterPassword(password)

        commonSteps
            .closeKeyboard()

        loginSteps
            .tapOnLoginButton()
    }
}