package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.foroom.utils.isLastChildOf
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

private val actualScope: Matcher<View> = isLastChildOf(withId(R.id.fragmentContainerView))

object ChatCreationPageMatchers {
    val chatNameField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        isDescendantOfA(actualScope),
        isDescendantOfA(withId(R.id.chatNameInput)),
        isDisplayed())
    }

    val createChatButton: Matcher<View> by lazy { allOf(
        withId(R.id.createChatButton),
        isDescendantOfA(actualScope),
        isDisplayed())
    }
}