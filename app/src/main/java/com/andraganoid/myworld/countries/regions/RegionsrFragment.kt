package com.andraganoid.myworld.countries.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.R
import com.andraganoid.myworld.utils.ARGS_REGION
import com.andraganoid.myworld.utils.ARGS_REGION_POS
import com.andraganoid.myworld.utils.MAX
import com.andraganoid.myworld.utils.MIN
import kotlinx.android.synthetic.main.regions_fragment.*

class RegionsrFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.regions_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_REGION) }?.apply {
            countriesViewPagerFragmentRegionTv.text = getString(ARGS_REGION)
            val pos = getInt(ARGS_REGION_POS)
            arrowLeft.visibility = if (pos == MIN) View.INVISIBLE else View.VISIBLE
            arrowRight.visibility = if (pos == MAX) View.INVISIBLE else View.VISIBLE
        }
    }
}
