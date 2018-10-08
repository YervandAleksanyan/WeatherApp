package dev.yervand.weatherapp.viewmodels.base

import android.databinding.ObservableBoolean

interface Command {
    fun isEnabled(): ObservableBoolean

    fun execute(obj: Any?)
}