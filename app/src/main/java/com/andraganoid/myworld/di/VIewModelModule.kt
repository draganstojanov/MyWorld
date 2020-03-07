package com.andraganoid.myworld.di

import com.andraganoid.myworld.countries.CountriesViewModelFactory
import com.andraganoid.myworld.repo.CountriesRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

        @Provides
        fun provideCountriesViewModelFactory(countriesRepository: CountriesRepository): CountriesViewModelFactory {
            return CountriesViewModelFactory(countriesRepository)
        }
    }

