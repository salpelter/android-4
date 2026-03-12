package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.design_system.components.loader.ContentLoaderView
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

object RegistrationPageMatchers {
    val userNameField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("მომხმარებლის სახელი"),
        isDescendantOfA(instanceOf(ContentLoaderView::class.java)))
    }

    val passwordField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("პაროლი"),
        isDescendantOfA(withId(R.id.passwordInput)),
        isDescendantOfA(instanceOf(ContentLoaderView::class.java)))
    }

    val repeatPasswordField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("გაიმეორეთ პაროლი"),
        isDescendantOfA(withId(R.id.repeatPasswordInput)),
        isDescendantOfA(instanceOf(ContentLoaderView::class.java)))
    }

    val registrationButton: Matcher<View> by lazy { allOf(
        withId(R.id.signUpButton),
        withText("რეგისტრაცია"),
        isDescendantOfA(instanceOf(ContentLoaderView::class.java)))
    }
}