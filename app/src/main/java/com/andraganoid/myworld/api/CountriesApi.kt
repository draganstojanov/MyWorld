package com.andraganoid.myworld.api

import com.andraganoid.myworld.model.Country
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    fun getAllCountriesAsync(): Deferred<List<Country>>

}