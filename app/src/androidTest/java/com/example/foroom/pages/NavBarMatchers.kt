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
private val navBarScope: Matcher<View> = allOf(withId(R.id.navBar), isDescendantOfA(actualScope))

object NavBarMatchers {
    val profileButton: Matcher<View> by lazy { allOf(
            withId(R.id.homeNavigationProfile),
            isDescendantOfA(navBarScope),
            isDisplayed())
    }

    val createChatButton: Matcher<View> by lazy { allOf(
        withId(R.id.homeNavigationCreateChat),
        isDescendantOfA(navBarScope),
        isDisplayed())
    }
}