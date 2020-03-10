package com.andraganoid.myworld.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.andraganoid.myworld.app.App
import com.andraganoid.myworld.model.Country
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Preferences {

    private val PREF_NAME = "com.andraganoid.myworld.SHARED_PREFERENCES"
    private val PREF_ALL_COUNTRIES = "all_countries"
    private val PREF_LAST_TIMESTAMP = "last_timestamp"
    private val TIMESTAMP_GAP = 24 * 60 * 60 * 1000L


    val sharedPreferences: SharedPreferences
        get() = App.appContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveAllCountries(countries: List<Country>) {
        saveLastTimestamp()
        val prefCountries = Gson().toJson(countries)
        sharedPreferences.edit().putString(PREF_ALL_COUNTRIES, prefCountries).apply()
    }

    fun getAllCountries(): List<Country> {
        val prefCountries = sharedPreferences.getString(PREF_ALL_COUNTRIES, null)
        return if (prefCountries != null) Gson().fromJson(prefCountries, object : TypeToken<ArrayList<Country>>() {}.type) else listOf()
    }

    private fun saveLastTimestamp() {
        sharedPreferences.edit().putLong(PREF_LAST_TIMESTAMP, System.currentTimeMillis()).apply()
    }

    fun lastTimestampCheck(): Boolean {

        Log.d("RESSPONSSE-PREF-1", "" + (System.currentTimeMillis() - sharedPreferences.getLong(PREF_LAST_TIMESTAMP, 0L)))
        Log.d("RESSPONSSE-PREF-2", "" + TIMESTAMP_GAP)

        val r = (System.currentTimeMillis() - sharedPreferences.getLong(PREF_LAST_TIMESTAMP, 0L)) > TIMESTAMP_GAP
        return r


        // return (System.currentTimeMillis() - sharedPreferences.getLong(PREF_LAST_TIMESTAMP, 0L)) > TIMESTAMP_GAP
    }

}