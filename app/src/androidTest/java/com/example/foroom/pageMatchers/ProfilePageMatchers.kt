package com.example.foroom.pageMatchers

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.design_system.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object ProfilePageMatchers {
    val signOutButton: Matcher<View> by lazy { Matchers.allOf(
        withId(R.id.listItemTextView),
        withText("გამოსვლა"))
    }

    val userImage: Matcher<View> by lazy { withId(R.id.userImageView) }
}