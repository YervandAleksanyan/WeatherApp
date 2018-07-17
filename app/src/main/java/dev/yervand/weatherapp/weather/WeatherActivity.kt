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

    lateinit var binding: ActivityWeatherBinding


    private lateinit var viewModel: WeatherActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        viewModel = ViewModelProviders.of(this, factory)[WeatherActivityViewModel::class.java]
        initCitiesList()
        viewModel.forecasts.observe(this, Observer {
            Toast.makeText(this, it?.city?.name, Toast.LENGTH_LONG).show()
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
                binding.cityPic.background = getDrawable(CitiesDataProvider.citiesPics[position])
                viewModel.getForecasts(CitiesDataProvider.citiesList[position])
            }
        }
    }
}
