package dev.yervand.weatherapp.viewmodels.weather

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import dev.yervand.weatherapp.domain.model.Forecast
import dev.yervand.weatherapp.domain.repository.ForecastRepositoryImpl
import dev.yervand.weatherapp.viewmodels.base.AsyncCommand
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseCommand
import dev.yervand.weatherapp.viewmodels.weather.commands.CitiesListInitializeCommand
import dev.yervand.weatherapp.viewmodels.weather.commands.FetchForecastsCommand
import dev.yervand.weatherapp.viewmodels.weather.commands.SelectForecastItemCommand
import dev.yervand.weatherapp.viewmodels.weather.mappers.WeatherViewModelMapper
import javax.inject.Inject

class WeatherViewModel @Inject constructor(repository: ForecastRepositoryImpl,
                                           mapper: WeatherViewModelMapper
) : AndroidViewModel(Application()) {
    //commands
    private val citiesInitializeCommand: BaseCommand
    var fetchForecasts: AsyncCommand = FetchForecastsCommand(repository, this, mapper)
    val selectItemCommand: BaseCommand = SelectForecastItemCommand(this, mapper)

    //properties
    var citiesMap: ObservableField<Map<Int, String>> = ObservableField()
    var currentPos: ObservableField<Int> = ObservableField()
    var temp: ObservableField<String> = ObservableField()
    var humidity: ObservableField<String> = ObservableField()
    var wind: ObservableField<String> = ObservableField()
    var weatherName: ObservableField<String> = ObservableField()
    var weatherIcon: ObservableField<String> = ObservableField()
    var dayForecasts: ObservableArrayList<Forecast> = ObservableArrayList()

    init {
        citiesInitializeCommand = CitiesListInitializeCommand(this)
        citiesInitializeCommand.execute(null)
    }
}