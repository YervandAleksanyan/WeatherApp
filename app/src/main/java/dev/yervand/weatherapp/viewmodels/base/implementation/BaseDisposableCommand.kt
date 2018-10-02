package dev.yervand.weatherapp.viewmodels.base.implementation

import dev.yervand.weatherapp.viewmodels.base.DisposableCommand
import io.reactivex.disposables.Disposable

abstract class BaseDisposableCommand : BaseCommand(), DisposableCommand {
    @Volatile
    var disposed = false

    private var task: Disposable? = null

    override fun dispose() {
        task?.let {
            it.dispose()
            task = null
        }
        disposed = true
    }

    override fun isDisposed() = disposed

    override fun execute(obj: Any) {
        task = executeCore(obj)
    }

    protected abstract fun executeCore(obj: Any): Disposable
}