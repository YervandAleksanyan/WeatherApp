package dev.yervand.weatherapp.viewmodels.base.validation

import com.baidu.unbiz.fluentvalidator.Validator
import com.baidu.unbiz.fluentvalidator.ValidatorContext
import com.baidu.unbiz.fluentvalidator.ValidatorHandler
import java.util.*

abstract class BaseValidationRules<T> : ValidatorHandler<T>(), Validator<T> {

    private var errorMessages = ArrayList<String>()


    fun addMessage(validationErrorMessage: String) {
        var found = false
        for (message in errorMessages) {
            if (message == validationErrorMessage) {
                found = true
                break
            }
        }
        if (!found) {
            errorMessages.add(validationErrorMessage)
        }
    }

    fun clear() {
        errorMessages = ArrayList()
    }


    override fun validate(context: ValidatorContext, t: T): Boolean {

        if (errorMessages.size == 0) {

            return true
        }
        val builder = StringBuilder()
        for (message in errorMessages) {
            builder.append(message)
            builder.append("\n")
        }
        context.addErrorMsg(builder.toString())
        return false
    }
}