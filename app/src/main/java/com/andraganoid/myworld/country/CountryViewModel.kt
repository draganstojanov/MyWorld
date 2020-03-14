package com.andraganoid.myworld.country

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.Preferences

class CountryViewModel(private val preferences: Preferences) : ViewModel() {

//    private val _country = MutableLiveData<Country>()
//    val country: LiveData<Country> get() = _country
//    private var countries: List<Country>? = null
//    private val _borders = MutableLiveData<List<Country>>()
//    val borders: LiveData<List<Country>> get() = _borders
//
//    fun getCountry(name: String) {
//        countries = preferences.getAllCountries()
//        _country.value = countries!!.filter { country -> country.name.equals(name) }.get(0)
//        getBorders()
//    }
//
//    private fun getBorders() {
//        val mBorders = arrayListOf<Country>()
//        _country.value?.borders?.forEach { border ->
//            mBorders.add(countries!!.filter { country -> country.alpha3Code.equals(border) }.get(0))
//        }
//        _borders.value = mBorders
//    }


    private var countries: List<Country>? = null
    private val _borders = MutableLiveData<List<Country>>()
    val borders: LiveData<List<Country>> get() = _borders

    init {
        countries = preferences.getAllCountries()
    }


    internal fun getBorders(country: Country) {
        val mBorders = arrayListOf<Country>()
        country.borders?.forEach { border ->
            mBorders.add(countries!!.filter { country -> country.alpha3Code.equals(border) }.get(0))
        }
        _borders.value = mBorders
    }

}
