package com.example.foroom.tests

import androidx.test.espresso.Espresso.pressBack
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChatTest : BaseTest() {
    @Test
    fun chatScenario() {
        // log in
        loginSteps
            .enterUserName(username)
            .enterPassword(password)

        commonSteps
            .closeKeyboard()

        loginSteps
            .tapOnLoginButton()

        // create chat
        val chatName = "Daniel Asaturov"

        navBarSteps
            .tapOnCreateChatButton()

        chatSteps
            .enterNewChatName(chatName)

        commonSteps
            .closeKeyboard()

        chatSteps
            .tapOnCreateChatButton()

        pressBack()

        // find chat
        commonSteps
            .closeKeyboard()

        mainSteps
            .swipeToChatWithName(chatName)
    }
}