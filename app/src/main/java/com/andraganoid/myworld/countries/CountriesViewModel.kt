package com.andraganoid.myworld.countries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.repo.CountriesRepositoryImpl

class CountriesViewModel(private val countriesRepository: CountriesRepository) : ViewModel() {

    val aaa = MutableLiveData<Int>(0)


}
