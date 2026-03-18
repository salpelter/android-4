package com.example.foroom.steps

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.util.HumanReadables
import com.alternator.foroom.R
import com.example.foroom.pages.ChatCreationPageMatchers
import com.example.foroom.pages.ChatPageMatchers
import com.example.foroom.utils.getText
import com.example.foroom.utils.staticWait
import com.example.foroom.utils.tap
import com.example.foroom.utils.typeText
import org.junit.Assert

class ChatSteps {
    fun enterNewChatName(chatName: String): ChatSteps {
        with(ChatCreationPageMatchers) {
            chatNameField.typeText(chatName)
        }
        return this
    }

    fun tapOnCreateChatButton(): ChatSteps {
        with(ChatCreationPageMatchers) {
            createChatButton.tap()
        }
        return this
    }

    fun enterMessage(message: String): ChatSteps {
        with(ChatPageMatchers) {
            messageInputField.typeText(message)
        }
        return this
    }

    fun tapOnSendMessageButton(): ChatSteps {
        with(ChatPageMatchers) {
            messageSendButton.tap()
            staticWait(5)
        }
        return this
    }

    // okay i know this is very complicated but at least it works
    // i tried other methods of checking the latest message but
    // this one is just the most consistent
    fun verifyMessageSentSuccessfully(author: String, expectedMessage: String): ChatSteps {
        onView(withId(R.id.messagesRecyclerView)).check { view, _ ->
            val recyclerView = view as RecyclerView
            Assert.assertTrue("No messages available", (recyclerView.adapter?.itemCount ?: 0) > 0)

            recyclerView.scrollToPosition(0)
            val viewHolder = recyclerView.findViewHolderForAdapterPosition(0)
                ?: throw AssertionError("Latest message item is not bound at adapter position 0")

            val itemView = viewHolder.itemView
            val actualAuthor = itemView.findViewById<TextView>(R.id.userNameTextView)?.text?.toString()
            val actualMessage = itemView.findViewById<TextView>(com.example.design_system.R.id.messageTextView)?.text?.toString()

            Assert.assertEquals(
                "Latest message author mismatch. Item: ${HumanReadables.describe(itemView)}",
                author,
                actualAuthor)

            Assert.assertEquals(
                "Latest message text mismatch. Item: ${HumanReadables.describe(itemView)}",
                expectedMessage,
                actualMessage)
        }
        return this
    }

    fun verifyCorrectChatIsOpen(expectedChatName: String): ChatSteps {
        with(ChatPageMatchers) {
            Assert.assertEquals(expectedChatName, headerChatName.getText())
        }
        return this
    }
}