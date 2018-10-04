package dev.yervand.weatherapp.di.modules.viewmodels

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.yervand.weatherapp.viewmodels.weather.WeatherActivityViewModel


@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WeatherActivityViewModel::class)
    internal abstract fun bindWeatherViewModel(weatherViewModel: WeatherActivityViewModel): ViewModel
}