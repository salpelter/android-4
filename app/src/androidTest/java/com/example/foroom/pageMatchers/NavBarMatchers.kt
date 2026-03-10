package com.example.foroom.pageMatchers

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers

object NavBarMatchers {
    val profileButton: Matcher<View> by lazy { withId(R.id.homeNavigationProfile) }
}