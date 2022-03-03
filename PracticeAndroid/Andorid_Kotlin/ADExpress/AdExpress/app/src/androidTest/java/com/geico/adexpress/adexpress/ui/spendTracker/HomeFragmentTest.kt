package com.geico.adexpress.adexpress.ui.spendTracker

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geico.adexpress.adexpress.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    private lateinit var scenario: FragmentScenario<HomeFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_AdExpress)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testHomeFragment() {
       // onView(withId(R.id.home_Fragment)).check(matches(isDisplayed()))
       // onView(withId(R.id.button_add_spend)).perform(click())
       // onView(withId(R.id.add_spend_fragment)).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        scenario.close()
    }
}