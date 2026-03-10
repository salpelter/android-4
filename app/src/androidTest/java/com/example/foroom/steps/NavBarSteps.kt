package com.example.foroom.steps

import com.example.foroom.helper.tap
import com.example.foroom.pageMatchers.NavBarMatchers

class NavBarSteps {
    fun clickOnProfileButton() {
        with(NavBarMatchers) {
            profileButton.tap()
        }
    }
}