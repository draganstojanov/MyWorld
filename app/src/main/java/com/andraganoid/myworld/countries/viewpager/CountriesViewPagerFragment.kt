package com.andraganoid.myworld.countries.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.CountriesViewPagerFragmentBinding
import com.andraganoid.myworld.utils.ARGS_REGION

class CountriesViewPagerFragment : Fragment() {

    private var _binding: CountriesViewPagerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CountriesViewPagerFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_REGION) }?.apply {
            binding.countriesViewPagerFragmentRegionTv.text = getString(ARGS_REGION)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
