package dev.yervand.weatherapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import dev.yervand.weatherapp.di.components.DaggerAppComponent

class WeatherApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out WeatherApp> {
        return DaggerAppComponent.builder().create(this)
    }
}
