package dev.yervand.weatherapp.weather

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.base.BaseActivity
import javax.inject.Inject

class WeatherActivity : BaseActivity() {
    companion object {
        fun start(activity: Activity) {
            val intent = Intent(activity, WeatherActivity::class.java)
            activity.startActivity(intent)
        }
    }

    @Inject
    lateinit var factory: WeatherViewModelFactory


    lateinit var viewModel: WeatherActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        viewModel = ViewModelProviders.of(this, factory)[WeatherActivityViewModel::class.java]
    }
}
