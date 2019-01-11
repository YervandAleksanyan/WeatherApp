package dev.yervand.weatherapp.test

import org.junit.runner.RunWith
import org.junit.runners.Suite
import java.util.*

@RunWith(Suite::class)
@Suite.SuiteClasses(WeatherActivityFeature::class)
object TestSuite {
    val ENGLISH = Locale("en", "GB")
    val SPANISH = Locale("es", "ES")
}