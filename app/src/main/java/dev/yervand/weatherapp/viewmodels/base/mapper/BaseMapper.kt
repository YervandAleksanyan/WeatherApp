package dev.yervand.weatherapp.viewmodels.base.mapper

interface BaseMapper<T, F> {
    fun map(viewModel: T, item: F)
}