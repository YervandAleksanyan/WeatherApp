package dev.yervand.weatherapp.domain.model


data class WeatherResponse(
        val cod: String,
        val message: Int,
        val city: City,
        val cnt: Int,
        val list: List<Forecast>
)

data class Forecast(
        val dt: Int,
        val temp: Temp,
        val pressure: Double,
        val humidity: Int,
        val weather: List<Weather>,
        val speed: Double,
        val deg: Int,
        val clouds: Int,
        val snow: Double
)

data class Temp(
        val day: Double,
        val min: Double,
        val max: Double,
        val night: Double,
        val eve: Double,
        val morn: Double
)

data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)

data class City(
        val geoname_id: Int,
        val name: String,
        val lat: Double,
        val lon: Double,
        val country: String,
        val iso2: String,
        val type: String,
        val population: Int
)