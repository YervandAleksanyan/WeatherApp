package dev.yervand.weatherapp.test

import android.app.Activity
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.test.InstrumentationTestCase
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import dev.yervand.weatherapp.R


class TestSteps : InstrumentationTestCase() {
    private var currentActivity: Activity? = null

    @Given("^I've launched \"([^\"]*)\"$")
    @Throws(Throwable::class)
    fun I_ve_launched_(activityClassName: String) {
        val targetPackage = instrumentation.targetContext.packageName
        val activityClass = Class.forName(activityClassName) as Class<Activity>

        currentActivity = launchActivity<Activity>(targetPackage, activityClass, null)
    }

    @When("^I click (.*)")
    @Throws(Throwable::class)
    fun I_click_(id: String) {
        Espresso.onView(ViewMatchers.withId(resolve(id))).perform(ViewActions.click())
    }

    @Then("^I should see \"([^\"]*)\"$")
    fun I_should_see_(text: String) {
        Espresso.onView(ViewMatchers.withText(text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Throws(NoSuchFieldException::class, IllegalAccessException::class)
    private fun resolve(id: String): Int {
        val clazz = R.id::class.java
        val field = clazz!!.getField(id)

        return field.getInt(field)
    }
}