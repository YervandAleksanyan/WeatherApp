package dev.yervand.weatherapp.viewmodels.weather.commands

import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseCommand
import dev.yervand.weatherapp.viewmodels.base.mapper.BaseMapper
import dev.yervand.weatherapp.viewmodels.weather.WeatherViewModel

class SelectForecastItemCommand(private var viewModel: WeatherViewModel,
                                private var mapper: BaseMapper<WeatherViewModel, Forecast>) : BaseCommand() {

    override fun execute(obj: Any?) {
        val item: Forecast = obj as Forecast
        mapper.map(viewModel, item)
    }
}