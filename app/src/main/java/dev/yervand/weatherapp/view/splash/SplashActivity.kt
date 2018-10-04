package dev.yervand.weatherapp.view.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dev.yervand.weatherapp.view.weather.WeatherActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherActivity.start(this)
    }
}