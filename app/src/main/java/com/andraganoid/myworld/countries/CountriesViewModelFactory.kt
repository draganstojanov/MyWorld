package com.andraganoid.myworld.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andraganoid.myworld.repo.CountriesRepository
import com.andraganoid.myworld.repo.CountriesRepositoryImpl
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class CountriesViewModelFactory @Inject constructor(private val countriesRepository: CountriesRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountriesViewModel::class.java)) {
            return CountriesViewModel(countriesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}