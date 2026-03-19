package com.example.foroom.utils

import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

// i have been trying to solve the page stacking/duplication
// issue for 3 days and this is the only thing i found that
// seems to work. i'm not 100% sure why but at least it works
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

