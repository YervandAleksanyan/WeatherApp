package dev.yervand.weatherapp.di.modules

import dagger.Module
import dagger.Provides
import dev.yervand.weatherapp.BuildConfig
import dev.yervand.weatherapp.domain.WeatherService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule {
    @Provides
    internal fun provideService(retrofit: Retrofit): WeatherService {
        return retrofit.create<WeatherService>(WeatherService::class.java)
    }

    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(WeatherService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(300, TimeUnit.SECONDS)
        builder.readTimeout(300, TimeUnit.SECONDS)
        builder.writeTimeout(300, TimeUnit.SECONDS)
        builder.addInterceptor(httpLoggingInterceptor)
        return builder.build()
    }

    @Provides
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }

}


