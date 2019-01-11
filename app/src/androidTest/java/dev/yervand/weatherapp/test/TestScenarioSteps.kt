package dev.yervand.weatherapp.test

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When

class TestScenarioSteps : GreenCoffeeSteps() {
    @Given("A")
    fun A() {
        assert(true) {
            "A"
        }
    }

    @When("B")
    fun b() {
        assert(true) {
            "B"
        }
    }

    @Then("C")
    fun c() {
        assert(false) {
            "C"
        }
    }
}
