package com.andraganoid.myworld.di


import com.andraganoid.myworld.BuildConfig
import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.countries.CountriesViewModel
import com.andraganoid.myworld.country.borders.BordersViewModel
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.utils.BASE_URL
import com.andraganoid.myworld.utils.Preferences
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module
import org.koin.dsl.single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Modules {

    private val viewModelModule = module {
        viewModel { CountriesViewModel(get()) }
        viewModel { BordersViewModel(get()) }
    }

    private val singleModule = module {
        single { CountriesRepository(get(), get()) }
        single { Preferences(androidContext()) }
    }

    private val networkModule = module {

        single { Gson() }

        single() {
            val builder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
            }
            builder.build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }

        single<CountriesApi> {
            get<Retrofit>().create(CountriesApi::class.java)
        }
    }

    val appModule =
        listOf(
            viewModelModule,
            singleModule,
            networkModule
        )


}



