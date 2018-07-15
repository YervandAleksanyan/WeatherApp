package dev.yervand.weatherapp.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
object RxModule {

    const val MAIN = "main"
    const val IO = "io"
    const val COMPUTATION = "computation"

    @Provides
    @Singleton
    @Named(MAIN)
    internal fun provideMainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    @Named(IO)
    internal fun provideIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Singleton
    @Named(COMPUTATION)
    internal fun provideComputationScheduler(): Scheduler {
        return Schedulers.computation()
    }


}