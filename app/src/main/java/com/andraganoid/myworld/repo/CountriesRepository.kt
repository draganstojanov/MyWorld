package com.andraganoid.myworld.repo

import android.util.Log
import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.model.Response
import com.andraganoid.myworld.utils.Preferences

class CountriesRepository(private val countriesApi: CountriesApi, private val preferences: Preferences) {

    suspend fun getAllCountries(): Response {
        val response = Response()
        var mCountries: List<Country> = listOf()
        if (preferences.lastTimestampCheck()) {
            Log.d("RESSPONSSE", "NETWORK")
            try {
                mCountries = countriesApi.getAllCountries().await()
                preferences.saveAllCountries(mCountries)
            } catch (exc: Exception) {
                response.isSucces = false
                Log.d("RESSPONSSE", "ERROR: " + exc)
            }
        } else {
            Log.d("RESSPONSSE", "PREFS")
            mCountries = preferences.getAllCountries()
        }
        response.apply {
            countries = mCountries
            isSucces = true
        }
        return response

    }

}
