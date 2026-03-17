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

private val topFragmentScope: Matcher<View> = isLastChildOf(withId(R.id.fragmentContainerView))

object LoginPageMatchers {
    val userNameField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.userNameInput)),
            isDescendantOfA(topFragmentScope),
            isDisplayed())
    }

    val passwordField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.passwordInput)),
            isDescendantOfA(topFragmentScope),
            isDisplayed())
    }

    val logInButton: Matcher<View> by lazy { allOf(
            withId(R.id.logInButton),
            isDescendantOfA(topFragmentScope),
            withText("ავტორიზაცია"),
            isDisplayed())
    }

    val registrationButton: Matcher<View> by lazy { allOf(
            withId(R.id.signUpButton),
            isDescendantOfA(topFragmentScope),
            withText("რეგისტრაცია"),
            isDisplayed())
    }

    val invalidPasswordMessage: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        isDescendantOfA(withId(R.id.passwordInput)),
        isDescendantOfA(topFragmentScope),
        withText("პაროლი არასწორია"),
        isDisplayed())
    }

    val nonExistentUserNameMessage: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        isDescendantOfA(withId(R.id.userNameInput)),
        isDescendantOfA(topFragmentScope),
        withText("მომხმარებელი ვერ მოიძებნა"),
        isDisplayed())
    }
}