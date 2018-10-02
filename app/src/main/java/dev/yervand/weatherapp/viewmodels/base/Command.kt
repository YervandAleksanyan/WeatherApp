package dev.yervand.weatherapp.viewmodels.base

import android.databinding.Bindable
import android.databinding.Observable

interface Command : Observable {
    @Bindable
    fun isEnabled(): Boolean

    fun setEnabled(value: Boolean)

    fun execute(obj: Any)
}