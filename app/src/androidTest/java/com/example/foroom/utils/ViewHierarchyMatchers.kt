package com.example.foroom.utils

import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

// i have been trying for 3 days to make the password change test work
// i don't know how exactly but finally it's somehow working
// so i'll just leave everything as is and not touch it anymore
fun isLastChildOf(parentMatcher: Matcher<View>): Matcher<View> {
    return object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description) {
            description.appendText("is last child of parent matching: ")
            parentMatcher.describeTo(description)
        }

        override fun matchesSafely(view: View): Boolean {
            val parent = view.parent as? ViewGroup ?: return false

            if (!parentMatcher.matches(parent))
                return false

            return parent.indexOfChild(view) == parent.childCount - 1
        }
    }
}

