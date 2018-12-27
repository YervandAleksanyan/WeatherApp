package dev.yervand.weatherapp.test;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import com.google.android.libraries.cloudtesting.screenshots.ScreenShotter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dev.yervand.weatherapp.view.weather.WeatherActivity;

@RunWith(AndroidJUnit4.class)
public class Stepdefs extends AndroidJUnitRunner {

    @Rule
    ManualTestRule<WeatherActivity> activityTestRule = new ManualTestRule<>(WeatherActivity.class);

    @Before
    void initialSetup() {
        Intents.init();
    }

    @After
    void tearDown() {
        Intents.release();
    }

    @Given("^I have navigated to Weather screen$")
    @Test
    public void iHaveNavigatedToWeatherScreen() throws Throwable {
        activityTestRule.launchActivity(new Intent());
        ScreenShotter.takeScreenshot("^I have navigated to Weather screen", activityTestRule.getActivity());
    }

    @When("^List of cities will {2}created$")
    @Test
    public void listOfCitiesWillCreated() throws Throwable {
        ScreenShotter.takeScreenshot("^List of cities will  created$", activityTestRule.getActivity());
    }

    @Then("^A cities list first item should be the same the entered data set first item$")
    @Test
    public void aCitiesListFirstItemShouldBeTheSameTheEnteredDataSetFirstItem() throws Throwable {
        assert (false);
        ScreenShotter.takeScreenshot("^List of cities will  created$", activityTestRule.getActivity());
    }
}
