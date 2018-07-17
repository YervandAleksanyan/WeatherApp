package dev.yervand.weatherapp.weather

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import dev.yervand.weatherapp.domain.model.WeatherResponse
import dev.yervand.weatherapp.domain.repository.ForeCastRepositoryImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherActivityViewModel @Inject constructor(private val repository: ForeCastRepositoryImpl
) : AndroidViewModel(Application()) {
    val forecasts: MutableLiveData<WeatherResponse> = MutableLiveData()

    val error: MutableLiveData<String> = MutableLiveData()

    fun getForecasts(cityName: String, daysRange: Int = 7) {
        repository.getSevenDayForecasts(cityName, daysRange)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onResponseReceived,
                        this::onError)
    }

    private fun onResponseReceived(response: WeatherResponse) {
        forecasts.value = response
    }

    private fun onError(th: Throwable) {
        error.value = th.message
    }
}