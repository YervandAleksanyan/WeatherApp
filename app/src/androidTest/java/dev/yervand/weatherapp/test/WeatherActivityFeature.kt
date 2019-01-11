package dev.yervand.weatherapp.test

import com.mauriciotogneri.greencoffee.GreenCoffeeConfig
import com.mauriciotogneri.greencoffee.GreenCoffeeTest
import com.mauriciotogneri.greencoffee.ScenarioConfig
import dev.yervand.weatherapp.test.TestSuite.ENGLISH
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.IOException


@RunWith(Parameterized::class)
class WeatherActivityFeature(scenarioConfig: ScenarioConfig) : GreenCoffeeTest(scenarioConfig) {


    @Test
    fun test() {
        start(WeatherActivitySteps(), TestScenarioSteps())
    }

    companion object {
        @Parameterized.Parameters(name = "{0}")
        @Throws(IOException::class)
        @JvmStatic
        fun scenarios(): Iterable<ScenarioConfig> {
            return GreenCoffeeConfig() // automatically take a screenshot if a test fails
                    .withFeatureFromAssets("assets/features/weather.feature")
                    .takeScreenshotOnFail()
                    .scenarios(ENGLISH)
        }
    }
}