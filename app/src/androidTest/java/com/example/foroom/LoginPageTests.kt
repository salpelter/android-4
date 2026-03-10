package com.example.foroom

import androidx.lifecycle.get
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.presentation.ui.util.datastore.user.ForoomUserDataStore
import com.example.shared.util.runtime.user_token.UserTokenRuntimeHolder
import com.example.foroom.steps.CommonSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.NavBarSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule
import org.koin.core.context.GlobalContext
import kotlin.random.Random

@RunWith(AndroidJUnit4::class)
class LoginPageTests {
    @get:Rule
    val activity = ActivityScenarioRule(ForoomActivity::class.java)

    val commonSteps = CommonSteps()
    val registrationSteps = RegistrationSteps()
    val loginSteps = LoginSteps()
    val navBarSteps = NavBarSteps()
    val profileSteps = ProfileSteps()

    @Before
    fun clearData() = runBlocking {
        GlobalContext.get().get<ForoomUserDataStore>().clearUserData()
        GlobalContext.get().get<UserTokenRuntimeHolder>().setUserToken("")
    }

    @Test
    fun validateInvalidPasswordMessagePresence() {
        val username = "daniel" + Random.nextInt(1000).toString()

        // register
        loginSteps
            .clickOnRegistrationButton()

        registrationSteps
            .enterUserName(username)
            .enterPassword(Constants.PASSWORD)
            .repeatPassword(Constants.PASSWORD)

        commonSteps
            .closeKeyboard()

        registrationSteps
            .clickOnRegistrationButton()

        // sing out
        navBarSteps
            .clickOnProfileButton()

        profileSteps
            .clickOnSignOutButton()

        // log in
        loginSteps
            .enterUserName(username)
            .enterPassword(Constants.PASSWORD + "123")

        commonSteps
            .closeKeyboard()

        loginSteps
            .clickOnLoginButton()
            .verifyInvalidPasswordMessagePresent()
    }
}
