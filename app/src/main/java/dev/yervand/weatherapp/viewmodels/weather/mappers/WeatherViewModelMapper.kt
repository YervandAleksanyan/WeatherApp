package dev.yervand.weatherapp.viewmodels.weather.mappers

import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.viewmodels.base.mapper.BaseMapper
import dev.yervand.weatherapp.viewmodels.weather.WeatherViewModel
import javax.inject.Inject

class WeatherViewModelMapper @Inject constructor() : BaseMapper<WeatherViewModel, Forecast> {
    override fun map(viewModel: WeatherViewModel, item: Forecast) {
        with(viewModel) {
            temp.set(item.main.temp.toInt().toString())
            humidity.set(item.main.humidity.toString())
            wind.set(item.wind.speed.toString())
            weatherName.set(item.weather[0].main.capitalize())
            weatherIcon.set(item.weather[0].icon)
        }
    }
}
