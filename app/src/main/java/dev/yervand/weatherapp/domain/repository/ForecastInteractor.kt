package dev.yervand.weatherapp.domain.repository

import android.arch.lifecycle.MutableLiveData
import dev.yervand.weatherapp.di.modules.RxModule
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class ForecastInteractor @Inject constructor(val repository: ForecastRepositoryImpl,
                                             @Named(RxModule.IO) val io: Scheduler,
                                             @Named(RxModule.MAIN) val main: Scheduler) {

    fun getData(cityName: String, response: MutableLiveData<Response>) {
        repository.getSevenDayForecasts(cityName)
                .subscribeOn(io)
                .observeOn(main)
                .doOnSubscribe { response.value = Response.loading() }
                .subscribe({ it -> response.value = Response.success(it) },
                        { it -> response.value = Response.error(it) })
    }
}