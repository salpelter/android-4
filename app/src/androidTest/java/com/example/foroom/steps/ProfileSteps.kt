package com.example.foroom.steps

import com.example.foroom.helper.isViewDisplayed
import com.example.foroom.helper.tap
import com.example.foroom.pageMatchers.ProfilePageMatchers

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