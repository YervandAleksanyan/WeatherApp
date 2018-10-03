package dev.yervand.weatherapp.viewmodels.base

import android.databinding.ObservableBoolean
import android.databinding.ObservableField

interface AsyncCommand : DisposableCommand {
    fun isBusy(): ObservableBoolean

    fun isFinished(): ObservableBoolean

    fun failureMessage(): ObservableField<String>
}