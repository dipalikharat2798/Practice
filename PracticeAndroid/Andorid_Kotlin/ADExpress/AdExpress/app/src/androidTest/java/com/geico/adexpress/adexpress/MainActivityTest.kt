package com.geico.adexpress.adexpress

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.geico.adexpress.adexpress.ui.activities.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }
    @Test
    fun checkValidatedUserName() {
        val perform = Espresso.onView(withId(R.id.username)).perform(
            ViewActions.typeText("u1TR94"),
            ViewActions.closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.password))
            .perform(ViewActions.typeText("U1TR94"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.login)).perform(ViewActions.click())

    }
    @Test
    fun checkValidatedPassword() {
        val perform = Espresso.onView(withId(R.id.username)).perform(
            ViewActions.typeText("U1TR94"),
            ViewActions.closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.password))
            .perform(ViewActions.typeText("U1TR94"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.login)).perform(ViewActions.click())

    }
    @Test
    fun checkValidatedUsernamePassword() {
        Espresso.onView(withId(R.id.username)).perform(
            ViewActions.typeText("U1TR94"),
            ViewActions.closeSoftKeyboard()
        )
        Espresso.onView(withId(R.id.password))
            .perform(ViewActions.typeText("U1TR94@123"), ViewActions.closeSoftKeyboard())
        Espresso.onView(withId(R.id.login)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.dashbord)).check(matches(isDisplayed()))
    }

}