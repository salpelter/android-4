package com.example.foroom.pages

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.alternator.foroom.R
import com.example.foroom.utils.isLastChildOf
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf

private val changePasswordScope: Matcher<View> = hasDescendant(withId(R.id.passwordInput))
private val changeLanguageScope: Matcher<View> = hasDescendant(anyOf(
    withId(R.id.languageButtonEng),
    withId(R.id.languageButtonGeo)))

private val topFragmentScope: Matcher<View> = isLastChildOf(withId(R.id.fragmentContainerView))

object ProfilePageMatchers {
    val signOutButton: Matcher<View> by lazy { allOf(
        withId(R.id.signOutItem),
        isDescendantOfA(topFragmentScope),
        isDisplayed())
    }

    val userImage: Matcher<View> by lazy { allOf(
            withId(R.id.userImageView),
            isDescendantOfA(topFragmentScope),
            isDisplayed())
    }

    val changePasswordButton: Matcher<View> by lazy { allOf(
        withId(R.id.changePasswordItem),
        isDescendantOfA(topFragmentScope),
        isDisplayed())
    }

    val changeLanguageButton: Matcher<View> by lazy { allOf(
        withId(R.id.changeLanguageItem),
        isDescendantOfA(topFragmentScope),
        isDisplayed())
    }

    val changeLanguageText: Matcher<View> by lazy { allOf(
        withId(com.example.design_system.R.id.listItemTextView),
        isDescendantOfA(changeLanguageButton),
        isDisplayed())
    }

    val newPasswordField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.passwordInput)),
            isDescendantOfA(changePasswordScope),
            isDisplayed())
    }

    val repeatNewPasswordField: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.inputEditText),
            isDescendantOfA(withId(R.id.repeatPasswordInput)),
            isDescendantOfA(changePasswordScope),
            isDisplayed())
    }

    val confirmChangePasswordButton: Matcher<View> by lazy { allOf(
            withId(com.example.design_system.R.id.actionButton),
            isDescendantOfA(changePasswordScope),
            withText("დადასტურება"),
            isDisplayed())
    }

    val georgianLanguageButton: Matcher<View> by lazy { allOf(
        withId(R.id.languageButtonGeo),
        isDescendantOfA(changeLanguageScope),
        isDisplayed())
    }

    val englishLanguageButton: Matcher<View> by lazy { allOf(
        withId(R.id.languageButtonEng),
        isDescendantOfA(changeLanguageScope),
        isDisplayed())
    }

    val profileUserName: Matcher<View> by lazy { allOf(
        withId(R.id.userNameTextView),
        isDescendantOfA(topFragmentScope),
        isDisplayed())
    }
}