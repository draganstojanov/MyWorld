package com.andraganoid.myworld.country.borders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.Preferences


class BordersViewModel(private val preferences: Preferences) : ViewModel() {

    private val _borders = MutableLiveData<List<Country>>()
    val borders: LiveData<List<Country>> get() = _borders

    internal fun getBorders(country: Country) {
        val mBorders = arrayListOf<Country>()
        country.borders?.forEach { border ->
            mBorders.add(preferences.getAllCountries().filter { country -> country.alpha3Code.equals(border) }[0])
        }
        _borders.value = mBorders
    }
}
