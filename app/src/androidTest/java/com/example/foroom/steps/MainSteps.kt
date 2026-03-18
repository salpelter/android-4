package com.example.foroom.steps

import com.example.foroom.data.Constants.CHAT_SWIPE_DELAY_MS
import com.example.foroom.data.Constants.CHAT_SWIPE_END_Y
import com.example.foroom.data.Constants.CHAT_SWIPE_START_Y
import com.example.foroom.pages.MainPageMatchers
import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.staticWait
import com.example.foroom.utils.swiper
import com.example.foroom.utils.tap
import com.example.foroom.utils.typeText
import org.junit.Assert.fail

class MainSteps {
    // i added maxSwipes parameter to limit the number of swipes
    // to not wait for too long since there are a lot of chats
    fun swipeToChatWithName(expectedChatName: String, maxSwipes: Int = 12) {
        with(MainPageMatchers) {
            repeat(maxSwipes + 1) { attempt ->
                if (chatTitle(expectedChatName).isViewDisplayed()) {
                    return
                }

                if (attempt == maxSwipes) {
                    fail("Chat '$expectedChatName' was not found after $maxSwipes swipes")
                }

                // i tried a lot of different parameters but they don't seem to work perfectly
                swiper(CHAT_SWIPE_START_Y, CHAT_SWIPE_END_Y, CHAT_SWIPE_DELAY_MS)
            }
        }
    }

    fun enterSearchQuery(chatName: String): MainSteps {
        with(MainPageMatchers) {
            staticWait()
            chatSearchField.typeText(chatName)
        }
        return this
    }

    fun searchForChat(chatName: String): MainSteps {
        // in case there are multiple
        staticWait()
        swipeToChatWithName(chatName)

        return this
    }

    fun tapOnChatMessageButton(chatName: String): MainSteps {
        with(MainPageMatchers) {
            chatMessageButton(chatName).tap()
            staticWait() // takes some time to load
        }
        return this
    }
}