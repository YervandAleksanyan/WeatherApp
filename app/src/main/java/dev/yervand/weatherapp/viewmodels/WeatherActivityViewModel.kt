package dev.yervand.weatherapp.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import dev.yervand.weatherapp.domain.repository.ForecastInteractor
import javax.inject.Inject

class WeatherActivityViewModel @Inject constructor(private val interceptor: ForecastInteractor
) : AndroidViewModel(Application()) {

}