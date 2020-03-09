package com.andraganoid.myworld.repo

import android.util.Log
import com.andraganoid.myworld.api.CountriesApi
import com.andraganoid.myworld.model.Response

class CountriesRepository(private val countriesApi: CountriesApi) {
    // fun getAllCountries(): Deferred<List<Country>> = countriesApi.getAllCountries()


    suspend fun getAllCountries(): Response {
        var response: Response = Response()
        try {
            response.apply {
                countries = countriesApi.getAllCountries().await()
                isSucces = true
            }

            Log.d("RESSPONSSE", "OK")
        } catch (exc: Exception) {
            response.isSucces = false
            Log.d("RESSPONSSE", "ERROR: " + exc)
        }
        return response

    }

}
