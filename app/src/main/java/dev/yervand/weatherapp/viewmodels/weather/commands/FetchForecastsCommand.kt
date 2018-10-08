package dev.yervand.weatherapp.viewmodels.weather.commands

import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.domain.model.WeatherResponse
import dev.yervand.weatherapp.domain.repository.ForecastRepositoryImpl
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseAsyncCommand
import dev.yervand.weatherapp.viewmodels.weather.WeatherActivityViewModel
import io.reactivex.Single

class FetchForecastsCommand(private var repository: ForecastRepositoryImpl,
                            private var viewModel: WeatherActivityViewModel) : BaseAsyncCommand<WeatherResponse>() {

    private var currentPos: Int = -1
    private var selectedCity: String? = ""

    override fun getAsyncAction(obj: Any?): Single<WeatherResponse>? {
        return if (currentPos != obj.toString().toInt()
        ) {
            currentPos = obj.toString().toInt()
            selectedCity = viewModel.citiesMap.get()?.values?.toList()?.get(currentPos)
            selectedCity?.let { repository.getSevenDayForecasts(it) }
        } else null
    }

    override fun handleResult(result: WeatherResponse): Boolean {
        return if (result.cod == WeatherService.SUCCESS) {
            viewModel.currentPos.set(currentPos)
            initForecastContent(result.list[0])
            viewModel.dayForecasts.clear()
            viewModel.dayForecasts.addAll(result.list)
            true
        } else false
    }

    private fun initForecastContent(forecast: Forecast) {
        with(viewModel) {
            temp.set(forecast.main.temp.toInt().toString())
            humidity.set(forecast.main.humidity.toString())
            wind.set(forecast.wind.speed.toString())
            weatherName.set(forecast.weather[0].main.capitalize())
            weatherIcon.set(forecast.weather[0].icon)
        }
    }
}