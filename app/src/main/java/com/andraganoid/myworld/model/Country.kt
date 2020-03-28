package com.andraganoid.myworld.model

import java.io.Serializable

data class Country(
    val area: Float? = 0f,
    val nativeName: String? = "",
    val capital: String? = "",
    val demonym: String? = "",
    val flag: String? = "",
    val alpha2Code: String? = "",
    val languages: List<LanguagesItem?>? = listOf(),
    val borders: List<String?>? = listOf(),
    val subregion: String? = "",
    val callingCodes: List<String?>? = listOf(),
    val regionalBlocs: List<RegionalBlocsItem?>? = listOf(),
    val gini: Double? = 0.0,
    val population: Int? = 0,
    val numericCode: String? = "",
    val alpha3Code: String? = "",
    val topLevelDomain: List<String?>? = listOf(),
    val timezones: List<String?>? = listOf(),
    val cioc: String? = "",
    val translations: Translations? = null,
    val name: String? = "",
    val altSpellings: List<String?>? = listOf(),
    val region: String? = "",
    val latlng: List<Float?>? = listOf(),
    val currencies: List<CurrenciesItem?>? = listOf()
) : Serializable
