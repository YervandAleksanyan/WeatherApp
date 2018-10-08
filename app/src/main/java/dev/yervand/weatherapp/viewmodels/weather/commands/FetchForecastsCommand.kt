package dev.yervand.weatherapp.viewmodels.weather.commands

import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.domain.model.WeatherResponse
import dev.yervand.weatherapp.domain.repository.ForecastRepositoryImpl
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseAsyncCommand
import dev.yervand.weatherapp.viewmodels.base.mapper.BaseMapper
import dev.yervand.weatherapp.viewmodels.weather.WeatherViewModel
import io.reactivex.Single

class FetchForecastsCommand(private var repository: ForecastRepositoryImpl,
                            private var viewModel: WeatherViewModel,
                            private var mapper: BaseMapper<WeatherViewModel, Forecast>) : BaseAsyncCommand<WeatherResponse>() {

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
            mapper.map(viewModel, result.list[0])
            viewModel.dayForecasts.clear()
            viewModel.dayForecasts.addAll(result.list)
            true
        } else false
    }
}