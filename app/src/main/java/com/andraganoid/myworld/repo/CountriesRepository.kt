package com.andraganoid.myworld.repo

import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.model.Response
import com.andraganoid.myworld.utils.Preferences

class CountriesRepository(private val countriesApi: CountriesApi, private val preferences: Preferences) {

    suspend fun getAllCountries(): Response {
        val response = Response()
        var mCountries: List<Country> = listOf()
        if (preferences.lastTimestampCheck()) {
            try {
                mCountries = countriesApi.getAllCountriesAsync().await()
                preferences.saveAllCountries(mCountries)
            } catch (exc: Exception) {
                response.isSuccess = false
            }
        } else {
            mCountries = preferences.getAllCountries()
        }
        response.apply {
            countries = mCountries
            isSuccess = true
        }
        return response
    }
}
