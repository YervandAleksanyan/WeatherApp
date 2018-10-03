package dev.yervand.weatherapp.viewmodels.base.implementation

import android.databinding.BaseObservable
import android.databinding.ObservableBoolean
import dev.yervand.weatherapp.viewmodels.base.Command

abstract class BaseCommand : BaseObservable(), Command {
    var enabled: ObservableBoolean = ObservableBoolean()

    init {
        enabled.set(true)
    }

    override fun isEnabled(): ObservableBoolean = enabled
}