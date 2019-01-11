package dev.yervand.weatherapp.test

import android.content.Intent
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When
import dev.yervand.weatherapp.view.weather.WeatherActivity
import org.junit.Rule

class WeatherActivitySteps : GreenCoffeeSteps() {

    @Rule
    var activityTestRule = ManualTestRule(WeatherActivity::class.java)


    @Given("I have navigated to Weather screen")
    fun iHaveNavigatedToWeatherScreen() {
        activityTestRule.launchActivity(Intent())
    }

    @When("List of cities will  created")
    fun listOfCitiesWillCreated() {
        WeatherModel.checkCitiesListNotEmpty()
    }

    @Then("A cities list first item should be the same the entered data set first item")
    fun aCitiesListFirstItemShouldBeTheSameTheEnteredDataSetFirstItem() {
        WeatherModel.checkAfterSelectListItemIsUpdated()
    }
}
