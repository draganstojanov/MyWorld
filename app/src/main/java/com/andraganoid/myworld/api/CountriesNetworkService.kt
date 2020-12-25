package com.andraganoid.myworld.api

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://restcountries.eu/rest/v2/")
    .addConverterFactory(GsonConverterFactory.create(Gson()))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

val countriesNetworkService: CountriesApi = retrofit.create(CountriesApi::class.java)
