package dev.yervand.weatherapp.viewmodels.base

interface AsyncCommand : DisposableCommand {
    fun IsBusy(): Boolean

    fun IsFinished(): Boolean

    fun FailureMessage(): String
}