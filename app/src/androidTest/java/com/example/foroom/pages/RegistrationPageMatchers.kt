package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.alternator.foroom.R
import com.example.design_system.components.loader.ContentLoaderView
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

object RegistrationPageMatchers {
    val userNameField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.userNameInput)),
            isDescendantOfA(isAssignableFrom(ContentLoaderView::class.java)),
            isDisplayed())
    }

    val passwordField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.passwordInput)),
            isDescendantOfA(isAssignableFrom(ContentLoaderView::class.java)),
            isDisplayed())
    }

    val repeatPasswordField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.repeatPasswordInput)),
            isDescendantOfA(isAssignableFrom(ContentLoaderView::class.java)),
            isDisplayed())
    }

    val registrationButton: Matcher<View> by lazy { allOf(
            withId(R.id.signUpButton),
            isDescendantOfA(isAssignableFrom(ContentLoaderView::class.java)),
            isDisplayed())
    }
}