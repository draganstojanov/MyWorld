package com.andraganoid.myworld.countries.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.RegionsFragmentBinding
import com.andraganoid.myworld.utils.ARGS_REGION
import com.andraganoid.myworld.utils.ARGS_REGION_POS
import com.andraganoid.myworld.utils.MAX
import com.andraganoid.myworld.utils.MIN


class RegionsFragment : Fragment() {

    private var _binding: RegionsFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RegionsFragmentBinding.inflate(inflater, container, false)
        prepare()
        return binding!!.root
    }

    private fun prepare() {
        arguments?.takeIf { it.containsKey(ARGS_REGION) }?.apply {
            binding?.countriesViewPagerFragmentRegionTv?.text = getString(ARGS_REGION)
            val pos = getInt(ARGS_REGION_POS)
            binding?.arrowLeft?.isVisible = pos != MIN
            binding?.arrowRight?.isVisible = pos != MAX
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
