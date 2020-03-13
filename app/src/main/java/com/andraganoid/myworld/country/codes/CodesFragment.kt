package com.andraganoid.myworld.country.codes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import kotlinx.android.synthetic.main.codes_fragment.*

class CodesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.codes_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            val country = getSerializable(ARGS_COUNTRY) as Country
            codesCode2Tv.text = country.alpha2Code
            codesCode3Tv.text = country.alpha3Code
            codesDomainTv.text = getStringFromArray(country.topLevelDomain)
            codesCodeTv.text = getStringFromArray(country.callingCodes)
            codesTimezonesTv.text = getStringFromArray(country.timezones)
        }
    }

    private fun getStringFromArray(mList: List<String?>?): String {
        val sb: StringBuilder = StringBuilder()
        mList?.forEach { item ->
            sb.append(item).append("   ")
        }
        return sb.toString()
    }
}
