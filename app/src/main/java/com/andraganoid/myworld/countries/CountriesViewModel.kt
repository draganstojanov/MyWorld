package com.andraganoid.myworld.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.utils.ALL
import com.andraganoid.myworld.utils.OTHER
import kotlinx.coroutines.launch
import java.util.*


class CountriesViewModel(private val countriesRepository: CountriesRepository) : ViewModel() {

    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> get() = _countries
    var regions: ArrayList<String>? = null

    init {
        getAllCountries()
    }

    fun getAllCountries() {
        viewModelScope.launch {
            val response = countriesRepository.getAllCountries()
            if (response.isSucces!!) {
                val regionsSet = sortedSetOf<String>()
                var other = false
                response.countries?.forEach { country ->
                    if (!country.region.isNullOrBlank()) {
                        regionsSet.add(country.region)
                    } else {
                        other = true
                    }
                }
                regions = arrayListOf(ALL)
                regions!!.addAll(regionsSet)
                if (other) {
                    regions!!.add(OTHER)
                }

                _countries.postValue(response.countries)
            }
        }
    }

}
