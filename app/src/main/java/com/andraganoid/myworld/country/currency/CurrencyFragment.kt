package com.andraganoid.myworld.country.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import kotlinx.android.synthetic.main.currency_fragment.*

class CurrencyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.currency_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            currencyRecView.adapter = CurrencyAdapter((arguments?.getSerializable(ARGS_COUNTRY) as Country).currencies)
        }
    }

}
