package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.utils.isLastChildOf
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

private val actualScope: Matcher<View> = isLastChildOf(withId(R.id.fragmentContainerView))

object MainPageMatchers {
    fun chatName(chatName: String): Matcher<View> = allOf(
        withId(com.example.design_system.R.id.chatTitleTextView),
        withText(chatName),
        isDescendantOfA(actualScope),
        isDisplayed()
    )
}