package dev.yervand.weatherapp.viewmodels.base.validation

import android.databinding.Observable
import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import android.util.Log
import com.baidu.unbiz.fluentvalidator.Validator
import java.util.*


class BaseViewModelValidator : ViewModelValidator<Any> {

    override fun validate(property: ObservableField<Any>): Boolean {
//        if (errors.containsKey(property)) {
//            errors.remove(property)
//        }
//
//
//        property.let {
//            val c = propertiesClassMap[property]
//            property.set(c?.newInstance())
//        }
//
//        val result = FluentValidator.checkAll().on(property.get(),
//                validationRules[property]).doValidate().result(toSimple())
//
//
//        if (!result.isSuccess()) {
//            errors[property] = result.getErrors().get(0)
//
//            return false
//        }
        return true
    }


    private val TAG = "ScheduleeValidator"

    private val validationRules = HashMap<ObservableField<Any>, Validator<*>>()

    private val errors = ObservableArrayMap<ObservableField<Any>, String>()


    private val propertiesClassMap = HashMap<ObservableField<*>, Class<*>>()


    protected fun addRule(property: ObservableField<Any>, propertyClass: Class<*>, validator: Validator<*>) {


        property.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: android.databinding.Observable, propertyId: Int) {
                PropertyChanged(sender)
            }
        })


        if (!validationRules.containsKey(property)) {

            if (!propertiesClassMap.containsKey(property)) {
                propertiesClassMap[property] = propertyClass
            }

            validationRules[property] = validator
        }
    }

    private fun PropertyChanged(sender: android.databinding.Observable) {

        val property = sender as ObservableField<Any>
        if (validationRules.size == 0) {
            Log.e(TAG, "There isn't t any defined validation rule")
            return
        }
        validate(property)

    }


    override fun validateAll(): Boolean {
        var isValid = true
        for (property in validationRules.keys) {
            val result = validate(property)
            if (!result) isValid = false

        }
        return isValid
    }


    override fun getError(property: ObservableField<Any>): String {
        return if (errors.containsKey(property)) {
            errors[property].toString()
        } else ""
    }

    override fun getErrors(): ObservableArrayMap<ObservableField<Any>, String> {
        return errors
    }

    override fun getAllErrorsInString(): ArrayList<String> {
        val res = ArrayList<String>()
        for (item in errors.keys) {
            res.add(errors[item].toString())
        }
        return res
    }
}