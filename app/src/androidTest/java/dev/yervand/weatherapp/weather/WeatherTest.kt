package dev.yervand.weatherapp.weather

import android.content.Intent
import android.support.test.espresso.intent.Intents
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import dev.yervand.weatherapp.base.ManualTestRule
import dev.yervand.weatherapp.view.weather.WeatherActivity
import dev.yervand.weatherapp.viewmodels.weather.CitiesViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class WeatherTest {

    private var activityTestRule: ManualTestRule<WeatherActivity> = ManualTestRule(WeatherActivity::class.java)

    @Before
    fun initialSetup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun loadDataBySelectedCity() {
        navigatedToLoginScreen()
        WeatherModel.checkFirstCountryNameIsValid(CitiesViewModel.citiesMap.values.first())
        WeatherModel.checkAfterSelectListItemIsUpdated()
        WeatherModel.checkViewDataIsUpdatedAfterSelect()
    }

    private fun navigatedToLoginScreen() {
        activityTestRule.launchActivity(Intent())
    }
}