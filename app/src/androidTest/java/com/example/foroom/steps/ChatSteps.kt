package com.example.foroom.steps

import com.example.foroom.data.Constants.CHAT_SWIPE_DELAY_MS
import com.example.foroom.data.Constants.CHAT_SWIPE_END_Y
import com.example.foroom.data.Constants.CHAT_SWIPE_START_Y
import com.example.foroom.pages.ChatCreationPageMatchers
import com.example.foroom.pages.MainPageMatchers
import com.example.foroom.utils.isViewDisplayed
import com.example.foroom.utils.swiper
import com.example.foroom.utils.tap
import com.example.foroom.utils.typeText
import org.junit.Assert.fail

class ChatSteps {
    fun enterNewChatName(chatName: String): ChatSteps {
        with(ChatCreationPageMatchers) {
            chatNameField.typeText(chatName)
        }
        return this
    }

    fun tapOnCreateChatButton(): ChatSteps {
        with(ChatCreationPageMatchers) {
            createChatButton.tap()
        }
        return this
    }
}