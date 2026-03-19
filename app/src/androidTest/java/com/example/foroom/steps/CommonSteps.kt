package com.example.foroom.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers

class CommonSteps {
    fun closeKeyboard(): CommonSteps {
        onView(ViewMatchers.isRoot()).perform(ViewActions.closeSoftKeyboard())

        return this
    }

}