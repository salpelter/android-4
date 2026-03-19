package com.example.foroom.steps

import com.example.foroom.utils.tap
import com.example.foroom.pages.NavBarMatchers
import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.staticWait

class NavBarSteps {
    fun tapOnProfileButton(): NavBarSteps {
        with(NavBarMatchers) {
            staticWait(1)
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