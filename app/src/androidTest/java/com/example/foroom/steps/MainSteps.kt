package com.example.foroom.steps

import com.example.foroom.data.Constants.CHAT_SWIPE_DELAY_MS
import com.example.foroom.data.Constants.CHAT_SWIPE_END_Y
import com.example.foroom.data.Constants.CHAT_SWIPE_START_Y
import com.example.foroom.pages.MainPageMatchers
import com.example.foroom.pages.MainPageMatchers.chatName
import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.swiper
import org.junit.Assert.fail

class MainSteps {
    // i added maxSwipes parameter to limit the number of swipes
    // to not wait for too long since there are a lot of chats
    fun swipeToChatWithName(expectedChatName: String, maxSwipes: Int = 12) {
        with(MainPageMatchers) {
            repeat(maxSwipes + 1) { attempt ->
                if (chatName(expectedChatName).isViewDisplayed()) {
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
}