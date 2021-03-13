package com.andraganoid.myworld.model

data class Response(
    val country: Country? = null,
    var countries: List<Country>? = null,
    var isSuccess: Boolean? = null
)
