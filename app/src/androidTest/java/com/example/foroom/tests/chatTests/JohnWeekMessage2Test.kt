package com.example.foroom.tests.chatTests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.foroom.data.Constants.JOHN_WICK_CHAT_NAME
import com.example.foroom.tests.BaseTest
import org.junit.Test
import org.junit.runner.RunWith

// task description says that we need to use a previously created chat
// but there's no chat that's supposed to be created in previous steps
// so i just did everything in the johnWeek chat
@RunWith(AndroidJUnit4::class)
class JohnWeekMessage2Test : BaseTest() {
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
        val message = "which module you like the most in the Automation Academy?"

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