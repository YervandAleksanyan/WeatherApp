package dev.yervand.weatherapp.weather

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.squareup.picasso.Picasso
import dev.yervand.weatherapp.R
import dev.yervand.weatherapp.base.BaseActivity
import dev.yervand.weatherapp.databinding.ActivityWeatherBinding
import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.domain.repository.Response
import dev.yervand.weatherapp.domain.repository.Status
import dev.yervand.weatherapp.presentation.BaseBindingAdapter
import dev.yervand.weatherapp.utils.CitiesDataProvider
import dev.yervand.weatherapp.weather.forecastlist.ForecastListAdapter
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

    @Inject
    lateinit var adapter: ForecastListAdapter

    private lateinit var binding: ActivityWeatherBinding

    private lateinit var viewModel: WeatherActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        viewModel = ViewModelProviders.of(this, factory)[WeatherActivityViewModel::class.java]
        initRv()
        initCitiesList()
        viewModel.citySelect.observe(this, Observer {
            it?.let { it1 ->
                viewModel.getForecasts(it1)
            }
        })
        viewModel.response.observe(this, Observer(this@WeatherActivity::handleResponse))
    }

    private fun initCitiesList() {
        binding.dropdownview.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, CitiesDataProvider.citiesList)
        binding.dropdownview.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (viewModel.lastSelectedPos != position) {
                    viewModel.lastSelectedPos = position
                    viewModel.citySelect.value = binding.dropdownview.selectedItem.toString()
                }
            }
        }
    }

    private fun initForecastContentUI(item: Forecast) {
        binding.humidityText.text = "${item.main.humidity} %"
        binding.temp.text = item.main.temp.toInt().toString()
        binding.windText.text = "${item.wind.speed} mph"
        binding.weatherText.text = item.weather[0].main.capitalize()
        Picasso
                .get()
                .load("${WeatherService.ICON_ENDPOINT}${item.weather[0].icon}.png")
                .error(R.drawable.ic_rain)
                .into(binding.weatherIcon)
        binding.cityPic.background = getDrawable(CitiesDataProvider.citiesPics[binding.dropdownview.selectedItemPosition])
    }

    private fun initRv() {
        binding.forecastsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.forecastsList.adapter = adapter
        adapter.setItemClickListener(object : BaseBindingAdapter.ItemClickListener<Forecast> {
            override fun onClick(item: Forecast, position: Int, view: View) {
                initForecastContentUI(item)
                unSelectAllItems()
                item.selected = true
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun provideItems(items: MutableList<Forecast>) {
        items[0].selected = true
        adapter.setItems(items)
        binding.forecastsList.scrollToPosition(0)
    }

    private fun handleResponse(response: Response?) {
        when (response?.status) {
            Status.LOADING -> {
                showProgressBar()
            }

            Status.SUCCESS -> {
                showUI()
                response.data?.list?.get(0)?.let {
                    hidProgressBar()
                    initForecastContentUI(it)
                    provideItems(response.data.list)
                }
            }

            Status.ERROR -> {
                hidProgressBar()
                hideUI()
                showError(response.error?.message)
            }
        }
    }

    private fun unSelectAllItems() {
        for (item in adapter.getItems())
            item.selected = false
    }

    private fun showUI() {
        binding.mainUiChild.visibility = View.VISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hidProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    private fun hideUI() {
        binding.mainUiChild.visibility = View.GONE
    }

    private fun showError(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}