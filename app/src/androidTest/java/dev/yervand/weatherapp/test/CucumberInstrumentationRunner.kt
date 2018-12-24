package dev.yervand.weatherapp.test

import android.os.Bundle
import android.support.test.runner.MonitoringInstrumentation
import cucumber.api.CucumberOptions
import cucumber.api.android.CucumberInstrumentationCore

@CucumberOptions(features = ["assets/features"], glue = ["dev.yervand.weatherapp.test.TestSteps"])
class CucumberInstrumentationRunner : MonitoringInstrumentation() {

    private val instrumentationCore: CucumberInstrumentationCore = CucumberInstrumentationCore(this)

    override fun onCreate(arguments: Bundle) {
        super.onCreate(arguments)
        instrumentationCore.create(arguments)
        start()
    }

    override fun onStart() {
        waitForIdleSync()
        instrumentationCore.start()
    }
}