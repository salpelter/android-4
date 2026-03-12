package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import org.hamcrest.Matcher

object NavBarMatchers {
    val profileButton: Matcher<View> by lazy {
        withId(R.id.homeNavigationProfile)
    }
}