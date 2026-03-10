package com.example.foroom.pageMatchers

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.design_system.components.loader.ContentLoaderView
import com.example.foroom.helper.withIndex
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.instanceOf

object LoginPageMatchers {
    val userNameField: Matcher<View> by lazy { Matchers.allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("მომხმარებლის სახელი"),
        isDescendantOfA(instanceOf(LinearLayout::class.java)),
        isDescendantOfA(withId(R.id.userNameInput)),
        withIndex(withId(com.example.design_system.R.id.inputEditText), 0))
    }

    val passwordField: Matcher<View> by lazy { Matchers.allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("პაროლი"),
        isDescendantOfA(instanceOf(LinearLayout::class.java)),
        isDescendantOfA(withId(R.id.passwordInput)),
        withIndex(withId(com.example.design_system.R.id.inputEditText), 0))
    }

    val logInButton: Matcher<View> by lazy { Matchers.allOf(
        withId(R.id.logInButton),
        withText("ავტორიზაცია"))
    }

    val registrationButton: Matcher<View> by lazy { Matchers.allOf(
        withId(R.id.signUpButton),
        withText("რეგისტრაცია"),
        isDescendantOfA(instanceOf(LinearLayout::class.java)),
        withIndex(withId(R.id.signUpButton), 0))
    }

    val invalidPasswordMessage: Matcher<View> by lazy { Matchers.allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        withText("პაროლი არასწორია"))
    }
}