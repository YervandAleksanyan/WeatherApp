package dev.yervand.weatherapp.viewmodels.base.validation

import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import java.util.*

interface ViewModelValidator<T> {
    fun validate(property: ObservableField<T>): Boolean

    fun validateAll(): Boolean

    fun getErrors(): ObservableArrayMap<ObservableField<T>, String>

    fun getAllErrorsInString(): ArrayList<String>

    fun getError(property: ObservableField<T>): String
}