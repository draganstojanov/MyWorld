package com.andraganoid.myworld.countries

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.model.Response
import com.andraganoid.myworld.repo.CountriesRepository
import kotlinx.coroutines.launch


class CountriesViewModel(private val countriesRepository: CountriesRepository) : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>>
        get() = _countries

    init {
        getAllCountries()
    }

    fun getAllCountries() {
        viewModelScope.launch {
            var response: List<Country> = listOf()
            try {
               response  = countriesRepository.getAllCountries().await()
                _countries.postValue(response)
                Log.d("RESSPONSSE", "OK")
            } catch (exc: Exception) {
                Log.d("RESSPONSSE", "ERROR: " + exc)
            }
        }
    }
}
