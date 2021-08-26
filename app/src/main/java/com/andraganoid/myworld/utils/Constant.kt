package com.andraganoid.myworld.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

const val ARGS_REGION = "region"
const val ARGS_REGION_POS = "region_pos"
const val OTHER = "Other"
const val ALL = "All"
const val ARGS_COUNTRY = "country"

const val MIN = 0
var MAX = 0

const val BASE_URL = "https://restcountries.eu/rest/v2/"

val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()