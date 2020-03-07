package com.andraganoid.myworld.di

import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.repo.CountriesRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun providesCountriesRepository(countriesApi: CountriesApi): CountriesRepository {
        return CountriesRepositoryImpl(countriesApi)
    }

}