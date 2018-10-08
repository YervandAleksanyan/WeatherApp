package dev.yervand.weatherapp.view.controls.adapter.binding

interface ItemBinder<T> {
    fun getLayoutRes(model: T): Int

    fun getBindingVariable(model: T): Int
}