package dev.yervand.weatherapp.domain.repository

import dev.yervand.weatherapp.domain.model.WeatherResponse
import io.reactivex.Single

interface ForeCastRepository {
    fun getSevenDayForecasts(cityName: String, daysRange: Int): Single<WeatherResponse>
}