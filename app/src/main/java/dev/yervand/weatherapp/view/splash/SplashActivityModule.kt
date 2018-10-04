package dev.yervand.weatherapp.view.splash

import dagger.Binds
import dagger.Module

@Module
abstract class SplashActivityModule {
    @Binds
    abstract fun activity(activity: SplashActivity): SplashActivity
}

