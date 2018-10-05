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
    //commands
    private val citiesInitializeCommand: BaseCommand
    var fetchForecasts: AsyncCommand = FetchForecastsCommand(repository, this)


    //properties
    var citiesMap: ObservableField<Map<Int, String>> = ObservableField()
    var currentPos: ObservableField<Int> = ObservableField()
    var temp: ObservableField<String> = ObservableField()
    var humidity: ObservableField<String> = ObservableField()
    var wind: ObservableField<String> = ObservableField()
    var weatherName: ObservableField<String> = ObservableField()
    var weatherIcon: ObservableField<String> = ObservableField()

    init {
        citiesInitializeCommand = CitiesListInitializeCommand(this)
        citiesInitializeCommand.execute(null)
    }
}