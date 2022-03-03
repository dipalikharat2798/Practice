package com.geico.adexpress.adexpress.util

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class LoginUtilsTest {

    @Before
    fun setUp() {
    }

    @Test
    fun checkUsernameForValidity() {
        val testEmail = "U1TR94"
        Assert.assertTrue(
            String.format("Email Validity Test failed for %s ", testEmail),
            LoginUtils.checkUsernameForValidity(testEmail)
        )
    }

    @Test
    fun checkPasswordForValidity() {
        val testPassword = "U1TR94@1"
        Assert.assertTrue(
            String.format("Password Validity Test failed for %s ", testPassword),
            LoginUtils.checkPasswordForValidity(testPassword)
        )
    }


    @Test
    fun validateRegistrationInput() {
        val result = LoginUtils.validateRegistrationInput(
            "U1TR94",
            "U1TR94@123"
        )
        Assert.assertTrue(result)
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
            "U1TR94",
            "U1TR94@123"
        )
        Assert.assertTrue(result)
    }
    @Test
    fun `contains empty username and password return false`() {
        val result = LoginUtils.validateRegistrationInput(
            "",
            ""
        )
        Assert.assertFalse(result)
    }

    @Test
    fun `password is less than 4 digits return false`() {
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