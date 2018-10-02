package dev.yervand.weatherapp.viewmodels.base.implementation

import android.databinding.BaseObservable
import dev.yervand.weatherapp.BR
import dev.yervand.weatherapp.viewmodels.base.Command

abstract class BaseCommand : BaseObservable(), Command {
    private var isEnabled: Boolean = true

    init {
        setEnabled(true)
    }

    override fun isEnabled() = isEnabled

    override fun setEnabled(value: Boolean) {
        isEnabled = value
        notifyPropertyChanged(BR.enabled)
    }
}