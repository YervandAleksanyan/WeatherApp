package dev.yervand.weatherapp.weather

import dagger.Binds
import dagger.Module

@Module
abstract class WeatherActivityModule {

    @Binds
    internal abstract fun activity(activity: WeatherActivity): WeatherActivity

}