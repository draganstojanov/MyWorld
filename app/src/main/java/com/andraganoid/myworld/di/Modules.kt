package com.andraganoid.memoryfields.di


import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.countries.CountriesViewModel
import com.andraganoid.myworld.country.borders.BordersViewModel
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.utils.Preferences
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        single {
            val countriesNetworkService: Retrofit = get()
            countriesNetworkService.create(CountriesApi::class.java)
        }
        single {
            Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
        }
    }

    val appModule =
        listOf(
            viewModelModule,
            singleModule,
            networkModule
        )


}


