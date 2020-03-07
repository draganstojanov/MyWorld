package com.andraganoid.myworld.repo

import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.model.Country
import kotlinx.coroutines.Deferred

class CountriesRepository(private val countriesApi: CountriesApi) {
    fun getAllCountries(): Deferred<List<Country>> = countriesApi.getAllCountries()
}
