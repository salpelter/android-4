package com.example.foroom.steps

import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.tap
import com.example.foroom.pages.ProfilePageMatchers

class ProfileSteps {
    fun clickOnSignOutButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            signOutButton.tap()
        }
        return this;
    }

    fun verifyUserImageVisibility(): ProfileSteps {
        with(ProfilePageMatchers) {
            userImage.isViewDisplayed()
        }
        return this;
    }
}