package com.andraganoid.myworld.api

import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.model.Response
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    fun getAllCountries(): Deferred<List<Country>>

}