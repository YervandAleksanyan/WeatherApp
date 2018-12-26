package dev.yervand.weatherapp.test

import android.content.Intent
import android.support.test.espresso.intent.Intents
import android.support.test.runner.AndroidJUnit4
import com.google.android.libraries.cloudtesting.screenshots.ScreenShotter
import cucumber.api.java.Before
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import dev.yervand.weatherapp.view.weather.WeatherActivity
import org.junit.After
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestSteps {
    @Rule
    private var activityTestRule: ManualTestRule<WeatherActivity> = ManualTestRule(WeatherActivity::class.java)

    @Before
    fun initialSetup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()

    }

    @Given("^I have navigated to Weather screen$")
    fun i_have_navigated_to_Weather_screen() {
        activityTestRule.launchActivity(Intent())
        ScreenShotter.takeScreenshot("^I have navigated to Weather screen", activityTestRule.activity)
    }

    @When("^List of cities will  created$")
    fun list_of_cities_will_created() {
        WeatherModel.checkCitiesListNotEmpty()
        ScreenShotter.takeScreenshot("^List of cities will  created$", activityTestRule.activity)
    }

    @Then("A cities list first item should be the same the entered data set first item")
    fun a_cities_list_first_item_should_be_the_same_the_entered_data_set_first_item() {
        assert(false)
        ScreenShotter.takeScreenshot("^List of cities will  created$", activityTestRule.activity)
    }
}