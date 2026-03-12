package com.example.foroom.steps

import com.example.foroom.utils.tap
import com.example.foroom.pages.NavBarMatchers

class NavBarSteps {
    fun clickOnProfileButton(): NavBarSteps {
        with(NavBarMatchers) {
            profileButton.tap()
        }
        return this;
    }
}