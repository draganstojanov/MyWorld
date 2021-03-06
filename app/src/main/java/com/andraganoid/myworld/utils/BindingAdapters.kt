package com.andraganoid.myworld.utils

import android.content.Context
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import java.text.NumberFormat


@BindingAdapter("number")
fun number(tv: TextView, number: Number) {
    tv.text = formattedNumber(number)
}

@BindingAdapter("getLatitude")
fun getLatitude(tv: TextView, country: Country) {
    tv.text = getLatLong(country.latlng, 0,tv.context)
}

@BindingAdapter("getLongitude")
fun getLongitude(tv: TextView, country: Country) {
    tv.text = getLatLong(country.latlng, 1, tv.context)
}

@BindingAdapter("stringFromArray")
fun getStringFromArray(tv: TextView, mList: List<String?>?) {
    val sb: StringBuilder = StringBuilder()
    var addn = false;
    mList?.forEach { item ->
        if (addn) {
            sb.append("\n")
        }
        addn = true
        sb.append(item)

    }
    tv.text = sb.toString()
}


private fun getLatLong(latLng: List<Float?>?, index: Int, context: Context): String =
    if (latLng!!.isNotEmpty()) latLng[index].toString() else context.resources.getString(R.string.no_data)

private val numberFormat = NumberFormat.getInstance()

private fun formattedNumber(number: Number): String {
    numberFormat.isGroupingUsed = true
    val n = if (number != number.toInt()) number.toInt() else number
    return numberFormat.format(n)
}
