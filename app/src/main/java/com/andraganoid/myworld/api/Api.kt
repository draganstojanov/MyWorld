package com.andraganoid.myworld.api

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "http://k7api.online:3004/"

//
//private val interceptor: HttpLoggingInterceptor
//    get() = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

//private fun getClient(context: Context): OkHttpClient = OkHttpClient.Builder()
//    .addInterceptor(interceptor)
//    .addInterceptor { chain ->
//        val request = chain.request().newBuilder()
//            .addHeader("Content-Type", "application/json")
//            .addHeader("device-id", App.deviceID)
//            .addHeader("device-name", getDeviceName())
//            .build()
//        val response = chain.proceed(request)
//        if (response.code == 412) {
//            context.app.apply {
//                runOnUiThread {
//                    toast(R.string.logged_on_another_device)
//                    ifAppIsInForegroundRedirectToLogin()
//                }
//            }
//        }
//        response
//    }
//    .build()

//
//fun getCallsApi(): CallsApi = Retrofit.Builder()
//    .client(getClient(context))
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//    .create(CallsApi::class.java)
//
//
//fun getWorldApi():