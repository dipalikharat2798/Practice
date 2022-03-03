package com.geico.adexpress.adexpress.ui.spendTracker


import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun whenInputIsValid(){
        val amount=100
        val desc="random description"
        val result=Validator.validateInput(amount,desc)
        assertThat(result).isTrue()
    }
    @Test
    fun whenInputIsInvalid(){
        val amount=0
        val desc="random description"
        val result=Validator.validateInput(amount,desc)
        assertThat(result).isFalse()
    }
}