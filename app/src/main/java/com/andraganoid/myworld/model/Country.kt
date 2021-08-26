package com.andraganoid.myworld.model

import com.squareup.moshi.Json
import java.io.Serializable

data class Country(
    @Json(name = "area") val area: Float? = 0f,
    @Json(name = "nativeName") val nativeName: String? = "",
    @Json(name = "capital") val capital: String? = "",
    @Json(name = "demonym") val demonym: String? = "",
    @Json(name = "flag") val flag: String? = "",
    @Json(name = "alpha2Code") val alpha2Code: String? = "",
    @Json(name = "languages") val languages: List<LanguagesItem?>? = listOf(),
    @Json(name = "borders") val borders: List<String?>? = listOf(),
    @Json(name = "subregion") val subregion: String? = "",
    @Json(name = "callingCodes") val callingCodes: List<String?>? = listOf(),
    @Json(name = "regionalBlocs") val regionalBlocs: List<RegionalBlocsItem?>? = listOf(),
    @Json(name = "gini") val gini: Double? = 0.0,
    @Json(name = "population") val population: Int? = 0,
    @Json(name = "numericCode") val numericCode: String? = "",
    @Json(name = "alpha3Code") val alpha3Code: String? = "",
    @Json(name = "topLevelDomain") val topLevelDomain: List<String?>? = listOf(),
    @Json(name = "timezones") val timezones: List<String?>? = listOf(),
    @Json(name = "cioc") val cioc: String? = "",
    @Json(name = "translations") val translations: Translations? = null,
    @Json(name = "name") val name: String? = "",
    @Json(name = "altSpellings") val altSpellings: List<String?>? = listOf(),
    @Json(name = "region") val region: String? = "",
    @Json(name = "latlng") val latlng: List<Float?>? = listOf(),
    @Json(name = "currencies") val currencies: List<CurrenciesItem?>? = listOf()
) : Serializable
