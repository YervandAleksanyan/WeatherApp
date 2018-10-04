package dev.yervand.weatherapp.viewmodels.weather

import dev.yervand.weatherapp.utils.CitiesDataProvider
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseCommand

class CitiesListInitializeCommand(private val viewModel: WeatherActivityViewModel) : BaseCommand() {

    override fun execute(obj: Any?) {
        viewModel.citiesList.set(CitiesDataProvider.citiesList)
    }
}