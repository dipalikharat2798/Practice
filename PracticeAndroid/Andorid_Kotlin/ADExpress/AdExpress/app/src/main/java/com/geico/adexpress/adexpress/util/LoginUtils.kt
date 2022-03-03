package com.geico.adexpress.adexpress.util

import java.util.regex.Matcher
import java.util.regex.Pattern

object LoginUtils {

    fun checkUsernameForValidity(userName: String?): Boolean {
        val USERNAME_PATTERN: Pattern =
            Pattern.compile("^[A-Z]([a-zA-Z0-9]){3,18}[a-zA-Z0-9]\$")
        val matcher: Matcher = USERNAME_PATTERN.matcher(userName)
        return matcher.find()
    }

    fun checkPasswordForValidity(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }

    /**
     * the input is not valid if ...
     * ... the username/password is empty
     * ...the email and password are valid
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        userName: String,
        password: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) {
            return false
        }
        if (checkUsernameForValidity(userName).equals(false) ||
            checkPasswordForValidity(password).equals(false)) {
            return false
        }
        if (checkUsernameForValidity(userName) && checkPasswordForValidity(password)) {
            return true
        }
        if (password.count { it.isDigit() } < 4) {
            return false
        }
        return true
    }
}