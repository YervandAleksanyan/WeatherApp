package dev.yervand.weatherapp.di.components

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.yervand.weatherapp.splash.SplashActivity
import dev.yervand.weatherapp.splash.SplashActivityModule
import dev.yervand.weatherapp.weather.WeatherActivity
import dev.yervand.weatherapp.weather.WeatherActivityModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [WeatherActivityModule::class])
    abstract fun bindWeatherActivity(): WeatherActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity
}