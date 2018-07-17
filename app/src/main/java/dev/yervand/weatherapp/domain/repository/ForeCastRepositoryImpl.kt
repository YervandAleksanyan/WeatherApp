package dev.yervand.weatherapp.domain.repository

import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.domain.model.WeatherResponse
import io.reactivex.Single
import javax.inject.Inject

class ForeCastRepositoryImpl @Inject constructor(private val service: WeatherService) : ForeCastRepository {
    override fun getSevenDayForecasts(cityName: String, daysRange: Int): Single<WeatherResponse> =
            service.getSevenDayWeatherData(cityName, daysRange)
}