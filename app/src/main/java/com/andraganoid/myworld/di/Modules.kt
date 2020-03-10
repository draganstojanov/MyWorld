package com.andraganoid.memoryfields.di


import com.andraganoid.myworld.api.CountriesNetworkService
import com.andraganoid.myworld.countries.CountriesViewModel
import com.andraganoid.myworld.country.CountryViewModel
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.utils.Preferences
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


object Modules {

    private val viewModelModule = module {
        viewModel { CountriesViewModel(get()) }
        viewModel { CountryViewModel(get()) }
    }

    private val singleModule = module {
        single { CountriesRepository(get(), get()) }
        single { Preferences() }
    }

    private val factoryModule = module {
//        factory { GameInit(get()) }
    }

    private val databaseModule = module {
//        single {
//            val db: MemoryDatabase = get()
//            db.savedGamesDao()
//        }
//        single {
//            val db: MemoryDatabase = get()
//            db.highScoresDao()
//        }
//        single {
//            Room.databaseBuilder(get(), MemoryDatabase::class.java, "memory_fields")
//                    .fallbackToDestructiveMigration()
//                    .build()
//        }
    }

    private val networkModule = module {
        single { CountriesNetworkService().getCountriesNetworkService() }
    }

    val appModule =
        listOf(
            viewModelModule,
            singleModule,
            factoryModule,
            databaseModule,
            networkModule
        )


}


