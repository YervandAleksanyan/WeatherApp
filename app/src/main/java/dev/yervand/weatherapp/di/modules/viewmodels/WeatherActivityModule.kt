package dev.yervand.weatherapp.di.modules.viewmodels

import dagger.Binds
import dagger.Module
import dev.yervand.weatherapp.view.weather.WeatherActivity

@Module
abstract class WeatherActivityModule {
    @Binds
    internal abstract fun activity(activity: WeatherActivity): WeatherActivity
}