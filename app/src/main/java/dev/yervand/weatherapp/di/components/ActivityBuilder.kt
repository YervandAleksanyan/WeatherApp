package dev.yervand.weatherapp.di.components

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.yervand.weatherapp.view.splash.SplashActivity
import dev.yervand.weatherapp.view.weather.WeatherActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector()
    abstract fun bindWeatherActivity(): WeatherActivity

    @ContributesAndroidInjector()
    abstract fun bindSplashActivity(): SplashActivity
}