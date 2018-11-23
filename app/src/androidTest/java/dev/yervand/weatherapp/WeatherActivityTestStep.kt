import android.content.Intent
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import dev.yervand.weatherapp.base.ManualTestRule
import dev.yervand.weatherapp.view.weather.WeatherActivity
import dev.yervand.weatherapp.viewmodels.weather.CitiesViewModel
import dev.yervand.weatherapp.weather.WeatherModel


class WeatherActivityTestStep {

    private var activityTestRule: ManualTestRule<WeatherActivity> = ManualTestRule(WeatherActivity::class.java)

    @Given("I have navigated to Weather screen")
    fun navigatedToLoginScreen() {
        activityTestRule.launchActivity(Intent())
    }

    @When("List of cities will  created")
    fun citiesListNotEmpty() {
        WeatherModel.checkCitiesListNotEmpty()
    }

    @Then("A cities list first item should be the same the entered data set first item")
    fun checkFirstCountryNameIsValid() {
        WeatherModel.checkFirstCountryNameIsValid(CitiesViewModel.citiesMap.values.first())
    }

//    @Test
//    fun loadDataBySelectedCity() {
//        navigatedToLoginScreen()
//        WeatherModel.checkFirstCountryNameIsValid(CitiesViewModel.citiesMap.values.first())
//        WeatherModel.checkAfterSelectListItemIsUpdated()
//        WeatherModel.checkViewDataIsUpdatedAfterSelect()
//    }
}