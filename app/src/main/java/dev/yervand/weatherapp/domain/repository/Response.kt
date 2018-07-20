package dev.yervand.weatherapp.domain.repository

import dev.yervand.weatherapp.domain.model.WeatherResponse


class Response constructor(val status: Status,
                           val data: WeatherResponse?,
                           val error: Throwable?) {
    companion object {

        fun loading(): Response {
            return Response(Status.LOADING, null, null)
        }

        fun success(data: WeatherResponse): Response {
            return Response(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable): Response {
            return Response(Status.ERROR, null, error)
        }
    }
}