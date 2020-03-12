package com.andraganoid.myworld.model

import java.io.Serializable

data class Country(
	val area: Float? = null,
	val nativeName: String? = null,
	val capital: String? = null,
	val demonym: String? = null,
	val flag: String? = null,
	val alpha2Code: String? = null,
	val languages: List<LanguagesItem?>? = null,
	val borders: List<String?>? = null,
	val subregion: String? = null,
	val callingCodes: List<String?>? = null,
	val regionalBlocs: List<RegionalBlocsItem?>? = null,
	val gini: Double? = null,
	val population: Int? = null,
	val numericCode: String? = null,
	val alpha3Code: String? = null,
	val topLevelDomain: List<String?>? = null,
	val timezones: List<String?>? = null,
	val cioc: String? = null,
	val translations: Translations? = null,
	val name: String? = null,
	val altSpellings: List<String?>? = null,
	val region: String? = null,
	val latlng: List<Float?>? = null,
	val currencies: List<CurrenciesItem?>? = null
):Serializable
