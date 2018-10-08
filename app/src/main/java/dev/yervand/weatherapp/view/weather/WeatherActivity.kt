package dev.yervand.weatherapp.view.weather

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import dev.yervand.weatherapp.BR
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.databinding.ActivityWeatherBinding
import dev.yervand.weatherapp.di.factories.WeatherViewModelFactory
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.view.base.BaseActivity
import dev.yervand.weatherapp.view.controls.adapter.binding.ItemBinderBase
import dev.yervand.weatherapp.viewmodels.weather.WeatherActivityViewModel
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


    private lateinit var binding: ActivityWeatherBinding

    private lateinit var viewModel: WeatherActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBindings()
    }

    private fun initBindings() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        viewModel = ViewModelProviders.of(this, factory)[WeatherActivityViewModel::class.java]
        binding.viewModel = viewModel
        binding.view = this
        binding.forecastsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    fun getViewBinder(): ItemBinderBase<Forecast> = ItemBinderBase(BR.forecast, R.layout.forecast_item)
}