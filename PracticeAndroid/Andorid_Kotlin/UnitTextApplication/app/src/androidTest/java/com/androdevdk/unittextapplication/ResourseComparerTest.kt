package com.androdevdk.unittextapplication

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourseComparerTest {
    private lateinit var resourseComparer: ResourseComparer

    @Before
    fun setUp() {
        resourseComparer = ResourseComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourseComparer.isEqual(context, R.string.app_name, "UnitTextApplication")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourseComparer.isEqual(context, R.string.app_name, "UnitTextApplicatio")
        assertThat(result).isFalse()
    }
}