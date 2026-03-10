package com.example.foroom.steps

import com.example.foroom.helper.tap
import com.example.foroom.pageMatchers.ProfilePageMatchers

class ProfileSteps {
    fun clickOnSignOutButton() {
        with(ProfilePageMatchers) {
            signOutButton.tap()
        }
    }
}