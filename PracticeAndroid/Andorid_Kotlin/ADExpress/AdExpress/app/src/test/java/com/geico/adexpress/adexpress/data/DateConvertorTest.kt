package com.geico.adexpress.adexpress.data


import org.junit.Test
import org.junit.Assert.*
import java.util.*


class DateConvertorTest {

    private val date = Date()

    @Test
    fun fromTimestamp() {
        assertEquals(DateConvertor().fromTimestamp(date.time), date)
    }

    @Test
    fun dateToTimestamp() {
        assertEquals(date.time, DateConvertor().dateToTimestamp(date))
    }
}