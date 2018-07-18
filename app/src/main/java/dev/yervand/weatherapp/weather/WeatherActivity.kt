package dev.yervand.weatherapp.weather

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.base.BaseActivity
import dev.yervand.weatherapp.databinding.ActivityWeatherBinding
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.utils.CitiesDataProvider
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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        viewModel = ViewModelProviders.of(this, factory)[WeatherActivityViewModel::class.java]
        initCitiesList()
        viewModel.forecasts.observe(this, Observer {
            binding.cityPic.background = getDrawable(CitiesDataProvider.citiesPics[binding.dropdownview.selectedItemPosition])
            it?.list?.let { it1 -> initForecastContentUI(it1, 0) }
        })
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun initCitiesList() {
        binding.dropdownview.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, CitiesDataProvider.citiesList)
        binding.dropdownview.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.getForecasts(CitiesDataProvider.citiesList[position])
            }
        }
    }

    private fun initForecastContentUI(list: List<Forecast>, pos: Int) {
        binding.humidityText.text = "${list[pos].main.humidity} %"
        binding.temp.text = list[pos].main.temp.toInt().toString()
        binding.windText.text = "${list[pos].wind.speed} mph"
        binding.weatherText.text = list[pos].weather[0].main.capitalize()
    }
}
