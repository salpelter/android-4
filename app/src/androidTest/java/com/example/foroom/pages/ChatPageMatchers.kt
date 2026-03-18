package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.foroom.utils.countViews
import com.example.foroom.utils.isLastChildOf
import com.example.foroom.utils.withIndex
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

private val actualScope: Matcher<View> = isLastChildOf(withId(R.id.fragmentContainerView))

object ChatPageMatchers {
    val messageInput: Matcher<View> = withId(R.id.messageInput)

    val messageInputField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(actualScope),
            isDescendantOfA(messageInput),
            isDisplayed()
        )
    }

    val messageSendButton: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.sendMessageButton),
            isDescendantOfA(actualScope),
            isDescendantOfA(messageInput),
            isDisplayed()
        )
    }

//    fun lastMessageContentByAuthor(userName: String): Matcher<View> {
//        val matcher = allOf(
//            withId(com.example.design_system.R.id.messageTextView),
//            isDescendantOfA(actualScope),
//            isDescendantOfA(hasDescendant(
//                allOf(withId(R.id.userNameTextView), withText(userName))
//            )),
//            isDisplayed())
//
//        val count = countViews(matcher)
//        if (count == 0) return matcher
//        return withIndex(matcher, count - 1)
//    }

    val headerChatName: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.chatNameTextView),
        isDescendantOfA(actualScope),
        isDescendantOfA(withId(R.id.chatHeaderView)),
        isDisplayed())
    }
}