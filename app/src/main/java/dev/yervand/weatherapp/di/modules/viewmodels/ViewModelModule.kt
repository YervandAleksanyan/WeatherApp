package dev.yervand.weatherapp.di.modules.viewmodels

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dev.yervand.weatherapp.viewmodels.weather.WeatherViewModel


@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(WeatherViewModel::class)
    internal abstract fun bindWeatherViewModel(weatherViewModel: WeatherViewModel): ViewModel
}