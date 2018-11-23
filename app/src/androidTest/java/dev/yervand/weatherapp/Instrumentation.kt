package dev.yervand.weatherapp

import android.os.Bundle
import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberInstrumentation
import cucumber.api.android.CucumberInstrumentationCore

@CucumberOptions(features = ["dev.yervand.weatherapp.test.assets/weather"], glue = ["dev.yervand.weatherapp.test.dev.yervand.weatherapp.WeatherActivityTestStep"])
class Instrumentation : CucumberInstrumentation() {

    private val instrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        instrumentationCore.create(arguments)
        start()
    }

    override fun onStart() {
        super.onStart()
        waitForIdleSync()
        instrumentationCore.start()
    }
}