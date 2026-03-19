package com.example.foroom.data

object DataGenerator {
    private const val UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private const val LOWER = "abcdefghijklmnopqrstuvwxyz"
    private const val DIGITS = "0123456789"
    private const val SYMBOLS = "!@#$%^&*-_=+"
    private const val ALPHANUMERIC = UPPER + LOWER + DIGITS

    fun getRandomString(length: Int = 8): String {
        return (1..length)
            .map { ALPHANUMERIC.random() }
            .joinToString("")
    }

    fun getRandomPassword(length: Int = 10): String {
        val minLength = 6
        val actualLength = if (length < minLength) minLength else length

        // guarantee valid chars
        val chars = mutableListOf(
            UPPER.random(),
            SYMBOLS.random(),
            DIGITS.random(),
            LOWER.random()
        )

        val allChars = UPPER + LOWER + DIGITS + SYMBOLS
        // seed + random chars to meet the required length
        repeat(actualLength - chars.size) {
            chars.add(allChars.random())
        }

        // shuffle so that the guaranteed chars are not always in the same position
        return chars.shuffled().joinToString("")
    }
}