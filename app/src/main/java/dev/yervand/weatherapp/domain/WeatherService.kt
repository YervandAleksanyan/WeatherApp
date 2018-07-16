package dev.yervand.weatherapp.domain

import dev.yervand.weatherapp.domain.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    companion object {
        val ENDPOINT = "api.openweathermap.org/"
    }

    @GET("data/2.5/forecast/daily")
    fun getSevenDayWeatherData(@Query("q") cityName: String, @Query("cnt") daysRange: Int): Single<WeatherResponse>

}