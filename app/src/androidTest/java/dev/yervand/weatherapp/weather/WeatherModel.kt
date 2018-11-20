package dev.yervand.weatherapp.weather

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText


object WeatherModel {

    fun selectCityFromList() {

    }

    fun checkFirstCountryNameIsValid(firstValidCountryName: String) {
        onView(withId(android.R.id.text1)).check(matches(withText(firstValidCountryName)))
    }
}