package com.androdevdk.test1app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class FirstTestcase {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun listGoesOverTheFold() {
        onView(withId(R.id.german)) // ViewMatchers - withId(R.id.german) is to
            // specify that we are looking for Button
            // with id = R.id.german
            .perform(click()); // ViewActions - Performs click action on view.
        onView(withId(R.id.preferred_language)) // ViewMatchers - withId(R.id.preferred_language)
            // is to specify that we are looking for a TextView
            // with id = R.id.preferred_language
            .check(matches(withText("German")));
    }
}