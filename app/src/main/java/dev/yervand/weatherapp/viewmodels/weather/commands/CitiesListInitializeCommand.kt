package dev.yervand.weatherapp.viewmodels.weather.commands

import dev.yervand.weatherapp.utils.CitiesViewModel
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseCommand
import dev.yervand.weatherapp.viewmodels.weather.WeatherActivityViewModel

class CitiesListInitializeCommand(private val viewModel: WeatherActivityViewModel) : BaseCommand() {

    override fun execute(obj: Any?) {
        viewModel.citiesMap.set(CitiesViewModel.citiesMap)
    }
}