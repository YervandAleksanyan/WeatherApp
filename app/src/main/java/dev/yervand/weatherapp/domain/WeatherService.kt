package dev.yervand.weatherapp.domain

import dev.yervand.weatherapp.domain.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    companion object {
        val ENDPOINT = "http://api.openweathermap.org"
        val ICON_ENDPOINT = "http://openweathermap.org/img/w/"
        val SUCCESS = "200"
    }

    @GET("/data/2.5/forecast")
    fun getSevenDayWeatherData(@Query("q") cityName: String, @Query("units") metrics: String = "metric"): Single<WeatherResponse>

}