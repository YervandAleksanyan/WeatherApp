package dev.yervand.weatherapp.weather

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import dev.yervand.weatherapp.R
import org.hamcrest.CoreMatchers.*


object WeatherModel {
    private const val CITY_NAME = "London"


    fun checkFirstCountryNameIsValid(firstValidCountryName: String) {
        onView(withId(android.R.id.text1)).check(matches(withText(firstValidCountryName)))
    }

    fun checkAfterSelectListItemIsUpdated() {
        selectCityFromList()
    }

    fun checkLoadingIndicatorIsShow() {
        waitForSeconds(3000)
        onView(withId(R.id.progress_indicator)).check(matches(isDisplayed()))
    }

    private fun selectCityFromList() {
        onView(withId(R.id.cities_list_drop_down)).perform(click())

        onData(allOf(`is`(instanceOf(String::class.java)), `is`(CITY_NAME))).perform(click())

        onView(withId(android.R.id.text1)).check(matches(withText(CITY_NAME)))
    }

    fun checkViewDataIsUpdatedAfterSelect() {
        onView(withId(R.id.city_pic)).check(matches(isDisplayed()))
        onView(withId(R.id.temp)).check(matches(isDisplayed()))
        onView(withId(R.id.weather_text)).check(matches(isDisplayed()))
        onView(withId(R.id.wind_text)).check(matches(isDisplayed()))
        onView(withId(R.id.humidity_text)).check(matches(isDisplayed()))
        onView(withId(R.id.forecasts_list)).check(matches(isDisplayed()))
    }

    private fun waitForSeconds(time: Long) {
        try {
            Thread.sleep(time)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}