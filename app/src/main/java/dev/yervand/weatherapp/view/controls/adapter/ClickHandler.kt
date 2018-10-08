package dev.yervand.weatherapp.view.controls.adapter

interface ClickHandler<T> {
    fun onClick(viewModel: T?)
}