package com.example.foroom.utils

import kotlin.random.Random

class RandomUsernameGenerator {
    companion object {
        @JvmStatic
        fun getRandomUsername(): String {
            val username = "daniel" + Random.nextInt(1000).toString()
            return username
        }
    }
}