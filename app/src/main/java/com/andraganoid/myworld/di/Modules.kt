package com.andraganoid.memoryfields.di


import com.andraganoid.myworld.api.CountriesNetworkService
import com.andraganoid.myworld.countries.CountriesViewModel
import com.andraganoid.myworld.country.borders.BordersViewModel
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.utils.Preferences
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

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
        single { CountriesNetworkService().countriesNetworkService }
    }

    val appModule =
        listOf(
            viewModelModule,
            singleModule,
            networkModule
        )


}


