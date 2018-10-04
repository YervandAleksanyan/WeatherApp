package dev.yervand.weatherapp.viewmodels.weather.commands

import dev.yervand.weatherapp.domain.model.WeatherResponse
import dev.yervand.weatherapp.domain.repository.ForecastRepositoryImpl
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseAsyncCommand
import dev.yervand.weatherapp.viewmodels.weather.WeatherActivityViewModel
import io.reactivex.Single

class FetchForecastsCommand(private var repository: ForecastRepositoryImpl,
                            private var viewModel: WeatherActivityViewModel) : BaseAsyncCommand<WeatherResponse>() {

    private var currentPos: Int = -1

    override fun getAsyncAction(obj: Any?): Single<WeatherResponse>? {
        currentPos = obj.toString().toInt()
        return viewModel.citiesMap.get()?.values?.toList()?.get(currentPos)?.let { repository.getSevenDayForecasts(it) }
    }

    override fun handleResult(result: WeatherResponse): Boolean {
        return if (result.cod == "200") {
            viewModel.currentPos.set(currentPos)
            true
        } else false
    }
}