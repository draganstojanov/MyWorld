package com.andraganoid.myworld.country.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import kotlinx.android.synthetic.main.general_fragment.*

class GeneralFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.general_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            val country = getSerializable(ARGS_COUNTRY) as Country
            generalCapitolTv.text = country.capital
            generalRegionTv.text = country.region
            generalSubregionTv.text = country.subregion
            generalPopulationTv.text = country.population.toString()
            generalAreaTv.text = country.area.toString()
            if (country.latlng!!.size > 0) {
                generalLatTv.text = country.latlng.get(0).toString()
                generalLonTv.text = country.latlng.get(1).toString()
            }
        }
    }

}
