package dev.yervand.weatherapp.domain.repository

import dev.yervand.weatherapp.domain.WeatherService
import dev.yervand.weatherapp.domain.model.WeatherResponse
import io.reactivex.Single
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(private val service: WeatherService) : ForecastRepository {
    override fun getSevenDayForecasts(cityName: String): Single<WeatherResponse> =
            service.getSevenDayWeatherData(cityName)
}