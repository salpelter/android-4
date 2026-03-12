package com.example.foroom.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants
import com.example.foroom.presentation.ui.activity.ForoomActivity
import com.example.foroom.presentation.ui.util.datastore.user.ForoomUserDataStore
import com.example.foroom.steps.CommonSteps
import com.example.foroom.steps.LoginSteps
import com.example.foroom.steps.NavBarSteps
import com.example.foroom.steps.ProfileSteps
import com.example.foroom.steps.RegistrationSteps
import com.example.foroom.utils.RandomUsernameGenerator
import com.example.foroom.utils.RandomUsernameGenerator.Companion.getRandomUsername
import com.example.shared.util.runtime.user_token.UserTokenRuntimeHolder
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.koin.core.context.GlobalContext
import kotlin.random.Random

// i couldn't understand why but the tests only work
// when run separately, i tried a lot of things but
// i coudln't run the class altogether
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class AuthenticationTests {
    @get:Rule
    val activity = ActivityScenarioRule(ForoomActivity::class.java)

    val commonSteps = CommonSteps()
    val registrationSteps = RegistrationSteps()
    val loginSteps = LoginSteps()
    val navBarSteps = NavBarSteps()
    val profileSteps = ProfileSteps()


    @Before
    @After
    fun setUp() {
        runBlocking {
            val dataStore = GlobalContext.get().get<ForoomUserDataStore>()
            dataStore.clearUserData()
            val userTokenHolder = GlobalContext.get().get<UserTokenRuntimeHolder>()
            userTokenHolder.setUserToken("")
        }
    }

    @Test
    fun TC1_validateInvalidPasswordMessagePresence() {
        val username = getRandomUsername()

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

    @Test
    fun TC3_validateNonExistentUserNameAndInvalidPasswordMessagesPresence() {
        val username = getRandomUsername()

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
        // the TC description says two messages should appear
        // but in reality only one does so i guess one of
        // the assertions is supposed to fail
        loginSteps
            .enterUserName(username + "123")
            .enterPassword(Constants.PASSWORD + "123")

        commonSteps
            .closeKeyboard()

        loginSteps
            .clickOnLoginButton()
            .verifyNonExistentUserNameMessagePresent()
            .verifyInvalidPasswordMessagePresent()
    }

    @Test
    fun TC2_validateUserRegistrationSuccessful() {
        // register
        loginSteps
            .clickOnRegistrationButton()

        registrationSteps
            .enterUserName(getRandomUsername())
            .enterPassword(Constants.PASSWORD)
            .repeatPassword(Constants.PASSWORD)

        commonSteps
            .closeKeyboard()

        registrationSteps
            .clickOnRegistrationButton()

        profileSteps
            .verifyUserImageVisibility()

        // sing out
        navBarSteps
            .clickOnProfileButton()

        profileSteps
            .clickOnSignOutButton()
    }
}