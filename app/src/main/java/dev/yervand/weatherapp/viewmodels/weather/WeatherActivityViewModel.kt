package dev.yervand.weatherapp.viewmodels.weather

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import dev.yervand.weatherapp.domain.repository.ForecastRepositoryImpl
import dev.yervand.weatherapp.viewmodels.base.AsyncCommand
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseCommand
import dev.yervand.weatherapp.viewmodels.weather.commands.CitiesListInitializeCommand
import dev.yervand.weatherapp.viewmodels.weather.commands.FetchForecastsCommand
import javax.inject.Inject

class WeatherActivityViewModel @Inject constructor(repository: ForecastRepositoryImpl
) : AndroidViewModel(Application()) {
    var citiesMap: ObservableField<Map<Int, String>> = ObservableField()
    var currentPos: ObservableField<Int> = ObservableField()
    private val citiesInitializeCommand: BaseCommand

    var fetchForecasts: AsyncCommand = FetchForecastsCommand(repository, this)

    init {
        citiesInitializeCommand = CitiesListInitializeCommand(this)
        citiesInitializeCommand.execute(null)
    }
}