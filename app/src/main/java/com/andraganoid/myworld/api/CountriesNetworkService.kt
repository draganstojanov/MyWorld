package com.andraganoid.myworld.api

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountriesNetworkService {

    private fun retrofit() = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/v2/")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    fun getCountriesNetworkService(): CountriesApi = retrofit().create(CountriesApi::class.java)

}
//
//fun createTalkOnAPI(context: Context): TalkOnApi = Retrofit.Builder()
//    .client(getClient(context))
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//    .create(TalkOnApi::class.java)