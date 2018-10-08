package dev.yervand.weatherapp.domain.repository

import dev.yervand.weatherapp.domain.model.WeatherResponse
import io.reactivex.Single

interface ForecastRepository {
    fun getSevenDayForecasts(cityName: String): Single<WeatherResponse>
}