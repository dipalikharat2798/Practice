package com.geico.adexpress.adexpress.ui.spendTracker

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geico.adexpress.adexpress.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddSpendFragmentTest {

    private lateinit var scenario : FragmentScenario<AddSpendFragment>
    @Before
    fun setUp() {
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_AdExpress)
        scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testAddSpend(){
        val amount=100
        val desc="Bought apples"
        onView(withId(R.id.edit_text_amount)).perform(ViewActions.typeText(amount.toString()), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.edit_text_description)).perform(ViewActions.typeText(desc), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.text_view_success_message)).check(matches(withText("Spend Added")))
    }
    @After
    fun tearDown() {
        scenario.close()
    }
}