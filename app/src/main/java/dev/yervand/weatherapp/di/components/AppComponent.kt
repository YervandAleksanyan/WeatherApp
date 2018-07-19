package dev.yervand.weatherapp.di.components

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.yervand.weatherapp.WeatherApp
import dev.yervand.weatherapp.di.modules.AppModule
import dev.yervand.weatherapp.di.modules.RetrofitModule
import dev.yervand.weatherapp.di.modules.RxModule
import dev.yervand.weatherapp.di.modules.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    RetrofitModule::class,
    ActivityBuilder::class,
    ViewModelModule::class,
    RxModule::class])
interface AppComponent : AndroidInjector<WeatherApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<WeatherApp>()
}