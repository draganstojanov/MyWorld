package com.andraganoid.myworld.api

import com.andraganoid.myworld.model.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    @GET("all")
    fun getAllCountries(): Call<ArrayList<Country>>

}