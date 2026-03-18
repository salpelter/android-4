package com.example.foroom.steps

import com.example.foroom.utils.tap
import com.example.foroom.pages.NavBarMatchers
import com.example.foroom.utils.isViewDisplayed

class NavBarSteps {
    fun tapOnProfileButton(): NavBarSteps {
        with(NavBarMatchers) {
            profileButton.tap()
        }
        return this
    }

    fun tapOnCreateChatButton(): NavBarSteps {
        with(NavBarMatchers) {
            createChatButton.tap()
        }
        return this
    }

    fun isNavBarVisible(): Boolean {
        with(NavBarMatchers) {
            return profileButton.isViewDisplayed()
        }
    }
}