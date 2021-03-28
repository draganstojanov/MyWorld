package com.andraganoid.myworld.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import coil.ImageLoader
import coil.decode.SvgDecoder

fun Context.hideKeyboard(view: View) {
    val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

val Context.svgImageLoader: ImageLoader
    get() = ImageLoader.Builder(this)
        .componentRegistry { add(SvgDecoder(this@svgImageLoader)) }
        .build()