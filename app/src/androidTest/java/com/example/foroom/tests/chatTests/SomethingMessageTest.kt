package com.example.foroom.tests.chatTests

import androidx.test.espresso.Espresso.pressBack
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants.JOHN_WICK_CHAT_NAME
import com.example.foroom.tests.BaseTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SomethingMessageTest : BaseTest() {
    @Test
    fun chatMessageScenario() {
        logIn(username, password)

        // find chat
        val chatName = "something"

        mainSteps
            .enterSearchQuery(chatName)

        commonSteps
            .closeKeyboard()

        mainSteps
            .searchForChat(chatName)
            .tapOnChatMessageButton(chatName)

        // send and verify message content
        val message = "Hello, I'm first user"

        chatSteps
            .verifyCorrectChatIsOpen(chatName)
            .enterMessage(message)
            .tapOnSendMessageButton()

        commonSteps
            .closeKeyboard()

        // change user
        pressBack()

        navBarSteps
            .tapOnProfileButton()

        val firstUserName = username

        profileSteps
            .tapOnSignOutButton()

        registerWithRandomCredentials()

        // find chat
        mainSteps
            .enterSearchQuery(chatName)

        commonSteps
            .closeKeyboard()

        mainSteps
            .searchForChat(chatName)
            .tapOnChatMessageButton(chatName)

        // verify first message, send response
        chatSteps
            .verifyCorrectChatIsOpen(chatName)
            .verifyMessageContentByAuthor(firstUserName, message)
            .enterMessage("Hello, I'm second user")
            .tapOnSendMessageButton()

        commonSteps
            .closeKeyboard()
    }
}