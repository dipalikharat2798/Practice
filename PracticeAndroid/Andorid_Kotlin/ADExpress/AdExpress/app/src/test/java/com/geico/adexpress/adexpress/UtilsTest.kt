package com.geico.adexpress.adexpress

import com.geico.adexpress.adexpress.util.LoginUtils
import org.junit.After
import org.junit.Assert
import org.junit.Test
import org.junit.Before


class UtilsTest {

    @Before
    fun setUp() {
    }

    @Test
    fun checkEmailForValidity() {
        val testEmail = "dipalikharat2798@gmail.com"
        Assert.assertTrue( String.format("Email Validity Test failed for %s ", testEmail),
            LoginUtils.checkUsernameForValidity(testEmail))
    }

    @Test
    fun isValidPassword() {
        val testPassword = "Dipali@123"
        Assert.assertTrue(
            String.format("Password Validity Test failed for %s ", testPassword),
            LoginUtils.checkPasswordForValidity(testPassword)
        )
    }

    @Test
    fun `empty username returns false`() {
        val result = LoginUtils.validateRegistrationInput(
            "",
            "123"
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `contains valid username and password return true`() {
        val result = LoginUtils.validateRegistrationInput(
            "dipalikharat@gmail.com",
            "Diapali@123"
        )
        Assert.assertTrue(result)
    }

    @Test
    fun `password is less than 6 digits return false`() {
        val result = LoginUtils.validateRegistrationInput(
            "dipalikharat@gmail.com",
            "1g"
        )
        Assert.assertFalse(result)
    }

    @After
    fun tearDown() {
    }
}