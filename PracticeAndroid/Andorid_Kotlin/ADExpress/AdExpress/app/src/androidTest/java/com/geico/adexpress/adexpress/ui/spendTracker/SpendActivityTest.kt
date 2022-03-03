package com.geico.adexpress.adexpress.ui.spendTracker


import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.geico.adexpress.adexpress.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SpendActivityTest {

    private lateinit var scenario: ActivityScenario<SpendActivity>

    @Before
    fun setUp() {
        scenario= launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testSpendActivity(){
        onView(withId(R.id.button_add_spend)).perform(click())
        val amount=100
        val desc = "Baught apples"
        onView(withId(R.id.edit_text_amount)).perform(ViewActions.typeText(amount.toString()))
        onView(withId(R.id.edit_text_description)).perform(ViewActions.typeText(desc))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_add)).perform(click())
        onView(ViewMatchers.withText(amount.toString())).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withText(desc)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))   }

    @After
    fun tearDown() {
        scenario.close()
    }
}