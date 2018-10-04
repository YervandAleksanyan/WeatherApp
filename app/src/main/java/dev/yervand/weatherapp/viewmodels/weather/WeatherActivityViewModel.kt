package dev.yervand.weatherapp.viewmodels.weather

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import dev.yervand.weatherapp.domain.repository.ForecastInteractor
import dev.yervand.weatherapp.viewmodels.base.implementation.BaseCommand
import javax.inject.Inject

class WeatherActivityViewModel @Inject constructor(private val interceptor: ForecastInteractor
) : AndroidViewModel(Application()) {
    var citiesList: ObservableField<ArrayList<String>> = ObservableField()

    init {
        val command: BaseCommand = CitiesListInitializeCommand(this)
        command.execute(null)
    }

}