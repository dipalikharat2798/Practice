package com.geico.adexpress.adexpress.util

import android.content.Context
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.geico.adexpress.adexpress.R
import com.geico.adexpress.adexpress.ui.activities.DashboardActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class RecyclerViewSampleTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(DashboardActivity::class.java)
    @Before
    fun setUp() {

    }
    @Test(expected = PerformException::class)
    fun itemWithText_doesNotExist() {
        // Attempt to scroll to an item that contains the special text.
        onView(withId(R.id.recyclerView)) // scrollTo will fail the test if no item matches.
            .perform(
                RecyclerViewActions.scrollTo<CustomAdapter.ViewHolder>(
                    hasDescendant(withText("item_element_text43"))
                )
            )
    }

    @Test
    fun scrollToItemBelowFold_checkItsText() {
        // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<CustomAdapter.ViewHolder>(
                    ITEM_BELOW_THE_FOLD, click()
                )
            )

        // Match the text in an item below the fold and check that it's displayed.
        val itemElementText = getApplicationContext<Context>().resources.getString(
            R.string.item_element_text
        ) +"_"+ ITEM_BELOW_THE_FOLD.toString()

        onView(withText(itemElementText)).check(matches(isDisplayed()))

    }

    @Test
    fun itemInMiddleOfList_hasSpecialText() {
        // First, scroll to the view holder using the isInTheMiddle matcher.
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.scrollToHolder(isInTheMiddle()))

        // Check that the item has the special text.
        val middleElementText =
            getApplicationContext<Context>().resources.getString(R.string.middle)
        onView(withText(middleElementText)).check(matches(isDisplayed()))
    }

    companion object {
        private const val ITEM_BELOW_THE_FOLD = 40

        /**
         * Matches the [CustomAdapter.ViewHolder]s in the middle of the list.
         */
        fun isInTheMiddle(): Matcher<CustomAdapter.ViewHolder?>? {
            return object : TypeSafeMatcher<CustomAdapter.ViewHolder?>() {


                override fun describeTo(description: Description) {
                    description.appendText("item in the middle")
                }

                override fun matchesSafely(item: CustomAdapter.ViewHolder?): Boolean {
                    return item!!.getIsInTheMiddle()
                }
            }
        }
    }

}