package com.example.foroom.pages

import android.view.View
import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.utils.withIndex
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

object LoginPageMatchers {
    val userNameField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("მომხმარებლის სახელი"),
        isDescendantOfA(instanceOf(LinearLayout::class.java)),
        isDescendantOfA(withId(R.id.userNameInput)),
        withIndex(withId(com.example.design_system.R.id.inputEditText), 0))
    }

    val passwordField: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.inputEditText),
        withHint("პაროლი"),
        isDescendantOfA(instanceOf(LinearLayout::class.java)),
        isDescendantOfA(withId(R.id.passwordInput)),
        withIndex(withId(com.example.design_system.R.id.inputEditText), 0))
    }

    val logInButton: Matcher<View> by lazy { allOf(
        withId(R.id.logInButton),
        withText("ავტორიზაცია"))
    }

    val registrationButton: Matcher<View> by lazy { allOf(
        withId(R.id.signUpButton),
        withText("რეგისტრაცია"),
        isDescendantOfA(instanceOf(LinearLayout::class.java)),
        withIndex(withId(R.id.signUpButton), 0))
    }

    val invalidPasswordMessage: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        withText("პაროლი არასწორია"))
    }

    val nonExistentUserNameMessage: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.descriptionTextView),
        withText("მომხმარებელი ვერ მოიძებნა"))
    }
}