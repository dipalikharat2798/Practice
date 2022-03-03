package com.androdevdk.unittextapplication


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {
    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `contains valid username and correct repeated password return true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Dipali",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `usernameis already taken return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "peter",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `confirm password is not equals to real password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "dk",
            "1234",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is less than 2 digits return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "dk",
            "1asdfg",
            "1asdfg"
        )
        assertThat(result).isFalse()
    }
}