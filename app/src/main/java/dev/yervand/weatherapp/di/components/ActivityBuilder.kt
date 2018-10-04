package dev.yervand.weatherapp.di.components

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.yervand.weatherapp.di.modules.viewmodels.WeatherActivityModule
import dev.yervand.weatherapp.view.splash.SplashActivity
import dev.yervand.weatherapp.view.splash.SplashActivityModule
import dev.yervand.weatherapp.view.weather.WeatherActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [WeatherActivityModule::class])
    abstract fun bindWeatherActivity(): WeatherActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun bindSplashActivity(): SplashActivity
}