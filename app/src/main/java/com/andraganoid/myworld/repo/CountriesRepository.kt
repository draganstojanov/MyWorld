package com.andraganoid.myworld.repo

import com.andraganoid.myworld.model.Country

interface CountriesRepository {

    fun getAllCountries(
        onSuccess: (countries: ArrayList<Country>) -> Unit,
        onFailure: (t: Throwable) -> Unit
    )
}