package com.example.foroom.tests.chatTests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants.JOHN_WICK_CHAT_NAME
import com.example.foroom.tests.BaseTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JohnWeekMessage1Test : BaseTest() {
    @Test
    fun chatMessageScenario() {
        logIn(username, password)

        // find chat
        mainSteps
            .enterSearchQuery(JOHN_WICK_CHAT_NAME)

        commonSteps
            .closeKeyboard()

        mainSteps
            .searchForChat(JOHN_WICK_CHAT_NAME)
            .tapOnChatMessageButton(JOHN_WICK_CHAT_NAME)

        // send and verify message content
        val message = "let's go for a drink"

        chatSteps
            .verifyCorrectChatIsOpen(JOHN_WICK_CHAT_NAME)
            .enterMessage(message)
            .tapOnSendMessageButton()


        commonSteps
            .closeKeyboard()

        chatSteps
            .verifyMessageContentByAuthor(username, message)
    }
}