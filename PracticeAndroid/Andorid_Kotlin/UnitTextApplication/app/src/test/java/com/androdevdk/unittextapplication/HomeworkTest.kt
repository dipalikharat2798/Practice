package com.androdevdk.unittextapplication

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class HomeworkTest {

    /**
     * Fibonacci Functions Unit Test case
     */
    @Test
    fun `fibonacci of 0 return 0`() {
        val result = Homework.fib(0)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `fibonacci of 0 return 1`() {
        val result = Homework.fib(1)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `fibonacci of n`() {
        val result = Homework.fib(4) + Homework.fib(5)
        assertThat(result).isEqualTo(8)
    }

    /**
     * CheckBraces Functions Unit Test case
     */
    @Test
    fun `check braces are set correctly return true`() {
        val result = Homework.checkBraces(
            "(a+b)"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `check braces are set correctly return false`() {
        val result = Homework.checkBraces(
            "(a+b))"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `check braces order is incorrect return false`() {
        val result = Homework.checkBraces(
            ")(a+b)"
        )
        assertThat(result).isFalse()
    }
}