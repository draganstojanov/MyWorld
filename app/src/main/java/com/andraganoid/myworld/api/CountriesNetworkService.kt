package com.andraganoid.myworld.api

import com.andraganoid.myworld.utils.BASE_URL
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesNetworkService {
    private fun retrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    fun countriesService(): CountriesApi = retrofit().create(CountriesApi::class.java)
}
