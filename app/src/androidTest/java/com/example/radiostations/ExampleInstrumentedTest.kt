package com.example.radiostations

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.radiostations.ui.activity.MainActivity


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testClickOnCardView() {

        Thread.sleep(500)
        onView(withId(R.id.recyclerview)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

    }



    @Test
    fun testInputNumeric(){
        Thread.sleep(500)
        onView(withId(R.id.action_search)).perform(typeText("123445568"))
    }


    @Test
    fun testInfoAlertDialog() {

        Thread.sleep(500)
        onView(withId(R.id.action_info)).perform(( click()))
        Thread.sleep(500)
        onView(withText("OK")).inRoot(isDialog()).check(matches(isDisplayed())).perform(pressBack());
    }






}
