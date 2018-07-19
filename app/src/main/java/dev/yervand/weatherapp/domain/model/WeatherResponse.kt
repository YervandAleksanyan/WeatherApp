package dev.yervand.weatherapp.domain.model

import com.google.gson.annotations.SerializedName


data class WeatherResponse(
        @SerializedName("cod") val cod: String,
        @SerializedName("message") val message: Double,
        @SerializedName("cnt") val cnt: Int,
        @SerializedName("list") val list: MutableList<Forecast>,
        @SerializedName("city") val city: City
)

data class City(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("coord") val coord: Coord,
        @SerializedName("country") val country: String,
        @SerializedName("population") val population: Int
)

data class Coord(
        @SerializedName("lat") val lat: Double,
        @SerializedName("lon") val lon: Double
)

data class Forecast(
        @SerializedName("dt") val dt: Long,
        @SerializedName("main") val main: Main,
        @SerializedName("weather") val weather: MutableList<Weather>,
        @SerializedName("clouds") val clouds: Clouds,
        @SerializedName("wind") val wind: Wind,
        @SerializedName("rain") val rain: Rain,
        @SerializedName("sys") val sys: Sys,
        @SerializedName("dt_txt") val dtTxt: String,
        var selected: Boolean
)

data class Sys(
        @SerializedName("pod") val pod: String
)

data class Main(
        @SerializedName("temp") val temp: Double,
        @SerializedName("temp_min") val tempMin: Double,
        @SerializedName("temp_max") val tempMax: Double,
        @SerializedName("pressure") val pressure: Double,
        @SerializedName("sea_level") val seaLevel: Double,
        @SerializedName("grnd_level") val grndLevel: Double,
        @SerializedName("humidity") val humidity: Int,
        @SerializedName("temp_kf") val tempKf: Double
)

data class Weather(
        @SerializedName("id") val id: Int,
        @SerializedName("main") val main: String,
        @SerializedName("description") val description: String,
        @SerializedName("icon") val icon: String
)

data class Clouds(
        @SerializedName("all") val all: Int
)

data class Wind(
        @SerializedName("speed") val speed: Double,
        @SerializedName("deg") val deg: Double
)

data class Rain(
        @SerializedName("3h") val h: Double
)













