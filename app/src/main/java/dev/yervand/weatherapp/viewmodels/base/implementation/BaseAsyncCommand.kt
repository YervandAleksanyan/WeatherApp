package dev.yervand.weatherapp.viewmodels.base.implementation

import android.databinding.Bindable
import dev.yervand.weatherapp.BR
import dev.yervand.weatherapp.viewmodels.base.AsyncCommand
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlin.properties.Delegates

abstract class BaseAsyncCommand<T> : BaseCommand(), AsyncCommand, Disposable {
    @get:Bindable
    var isBusy: Boolean by Delegates.observable(true) { _, _, _ ->
        notifyPropertyChanged(BR.busy)
    }

    @get:Bindable
    var isFinished: Boolean by Delegates.observable(false) { _, _, _ ->
        notifyPropertyChanged(BR.finished)
    }

    @get:Bindable
    var failureMessage: String by Delegates.observable("") { _, _, _ ->
        notifyPropertyChanged(BR.failureMessage)
    }

    private var action: Disposable? = null
    @Volatile
    private var disposed: Boolean = false

    override fun execute(obj: Any) {
        if (!isEnabled()) return
        val task = getAsyncAction(obj)
        if (task != null) {
            isBusy = true
            isFinished = false
            failureMessage = ""
            action = task
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith<DisposableSingleObserver<T>>(getAsyncActionObserver())
        }
    }

    protected abstract fun getAsyncAction(obj: Any): Single<T>?

    protected abstract fun handleResult(result: T): Boolean

    protected fun handleError(e: Throwable) {
        failureMessage = "Something went wrong while executing the action. Please try again"
    }

    override fun dispose() {
        disposeAction()
        disposed = true
    }

    override fun isDisposed(): Boolean {
        return disposed
    }

    override fun notifyPropertyChanged(fieldId: Int) {
        super.notifyPropertyChanged(fieldId)
        if (fieldId == BR.busy) {
            setEnabled(!isBusy)
        }
    }

    private fun getAsyncActionObserver(): DisposableSingleObserver<T> {
        return object : DisposableSingleObserver<T>() {
            override fun onSuccess(result: T) {
                isBusy = false
                isFinished = handleResult(result)
                disposeAction()
            }

            override fun onError(e: Throwable) {
                isBusy = false
                isFinished = true
                handleError(e)
                disposeAction()
            }

        }
    }

    private fun disposeAction() {
        if (action != null && !action!!.isDisposed) {
            action!!.dispose()
            action = null
        }
    }
}


