package com.androdevdk.test1app

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RecyclerviewActivityTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<RecyclerviewActivity>()

    @Before
    fun setUp() {
    }
    @Test
    fun check(){
        // verify the visibility of recycler view on screen
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
// perform click on view at 3rd position in RecyclerView
//        onView(ViewMatchers.withId(R.id.itemTextView))
//            .check(matches(withText("Item 4")));
    }
    @After
    fun tearDown() {
    }
}