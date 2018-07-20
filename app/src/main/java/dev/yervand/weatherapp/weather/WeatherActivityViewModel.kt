package dev.yervand.weatherapp.weather

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import dev.yervand.weatherapp.domain.repository.ForecastInteractor
import dev.yervand.weatherapp.domain.repository.Response
import javax.inject.Inject

class WeatherActivityViewModel @Inject constructor(private val interceptor: ForecastInteractor
) : AndroidViewModel(Application()) {
    val response: MutableLiveData<Response> = MutableLiveData()
    val citySelect: MutableLiveData<String> = MutableLiveData()
    var lastSelectedPos = -1


    var temp: ObservableField<String> = ObservableField()
    var weatherIconUrl: ObservableField<String> = ObservableField()
    var weatherText: ObservableField<String> = ObservableField()
    var windText: ObservableField<String> = ObservableField()
    var humidityText: ObservableField<String> = ObservableField()
    var cityBackground: ObservableField<Int> = ObservableField()

    fun getForecasts(cityName: String) {
        interceptor.getData(cityName, response)
    }
}