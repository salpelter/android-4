package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.utils.isLastChildOf
import com.example.foroom.utils.withIndex
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

private val actualScope: Matcher<View> = isLastChildOf(withId(R.id.fragmentContainerView))

object MainPageMatchers {
    val chatSearchField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(withId(R.id.searchChatInput)),
        isDescendantOfA(actualScope),
        isDisplayed())
    }

    fun chatTitle(chatName: String): Matcher<View> = allOf(
        withId(com.example.design_system.R.id.chatTitleTextView),
        withText(chatName),
        isDescendantOfA(actualScope),
        isDisplayed()
    )

    fun chatMessageButton(chatName: String): Matcher<View> = withIndex(allOf(
        withId(com.example.design_system.R.id.sendMessageButton),
        isDescendantOfA(actualScope),
        hasSibling(chatTitle(chatName)),
        isDisplayed()
        ),
        index = 0
    )
}