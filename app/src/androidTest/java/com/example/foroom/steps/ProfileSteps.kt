package com.example.foroom.steps

import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.tap
import com.example.foroom.pages.ProfilePageMatchers
import com.example.foroom.utils.getText
import com.example.foroom.utils.staticWait
import com.example.foroom.utils.typeText
import org.junit.Assert

class ProfileSteps {
    fun tapOnSignOutButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            signOutButton.tap()
        }
        return this
    }

    fun verifyUserImageVisibility(): ProfileSteps {
        with(ProfilePageMatchers) {
            userImage.isViewDisplayed()
        }
        return this
    }

    fun tapOnChangePasswordButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            changePasswordButton.tap()
        }
        return this
    }

    fun tapOnChangeLanguageButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            changeLanguageButton.tap()
        }
        return this
    }

    fun tapOnGeorgianLanguageButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            georgianLanguageButton.tap()
        }
        return this
    }

    fun verifyLanguageChangedToEnglish() {
        staticWait()
        with(ProfilePageMatchers) {
            Assert.assertEquals("Change Language", changeLanguageText.getText())
        }
    }

    fun verifyLanguageChangedToGeorgian() {
        staticWait()
        with(ProfilePageMatchers) {
            Assert.assertEquals("ენის შეცვლა", changeLanguageText.getText())
        }
    }

    fun tapOnEnglishLanguageButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            englishLanguageButton.tap()
        }
        return this
    }

    fun enterNewPassword(password: String): ProfileSteps {
        with(ProfilePageMatchers) {
            newPasswordField.typeText(password)
        }
        return this
    }

    fun repeatNewPassword(password: String): ProfileSteps {
        with(ProfilePageMatchers) {
            repeatNewPasswordField.typeText(password)
        }
        return this
    }

    fun tapOnConfirmChangePasswordButton(): ProfileSteps {
        with(ProfilePageMatchers) {
            confirmChangePasswordButton.tap()
        }
        return this
    }

    fun verifyCorrectUserLoggedIn(userName: String): ProfileSteps {
        with(ProfilePageMatchers) {
            Assert.assertEquals(userName, profileUserName.getText())
        }
        return this
    }
}