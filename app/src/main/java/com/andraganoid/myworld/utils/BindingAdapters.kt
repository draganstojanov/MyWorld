package com.andraganoid.myworld.utils

import android.content.Context
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import org.koin.core.Koin
import org.koin.core.context.GlobalContext


@BindingAdapter("getLatitude")
fun getLatitude(tv: TextView, country: Country) {
    tv.text = getLatLong(country.latlng, 0)
}

@BindingAdapter("getLongitude")
fun getLongitude(tv: TextView, country: Country) {
    tv.text = getLatLong(country.latlng, 1)
}

@BindingAdapter("stringFromArray")
fun getStringFromArray(tv: TextView, mList: List<String?>?) {
    val sb: StringBuilder = StringBuilder()
    mList?.forEach { item ->
        sb.append(item).append("   ")
    }
    tv.text = sb.toString()
}

private val koin: Koin = GlobalContext.get().koin
private val context: Context by koin.inject()

private fun getLatLong(latLng: List<Float?>?, index: Int): String =
    if (latLng!!.size > 0) latLng.get(index).toString() else context.resources.getString(R.string.no_data)

