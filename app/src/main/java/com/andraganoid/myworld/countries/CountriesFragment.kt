package com.andraganoid.myworld.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.andraganoid.myworld.countries.regions.RegionsAdapter
import com.andraganoid.myworld.databinding.CountriesFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ALL
import com.andraganoid.myworld.utils.OTHER
import com.andraganoid.myworld.utils.hideKeyboard
import org.koin.android.viewmodel.ext.android.viewModel


class CountriesFragment : Fragment() {

    private var _binding: CountriesFragmentBinding? = null
    private val binding get() = _binding

    private val viewModel: CountriesViewModel by viewModel()
    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CountriesFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = binding?.countriesFragmentViewPager!!
        countriesAdapter = CountriesAdapter(this::onCountryClick)
        binding?.countriesRecView?.adapter = countriesAdapter
        setObservers()
        regionSelector()
        searchListener()
        binding?.countriesFragmentKeyboardBtn?.setOnClickListener { activity?.hideKeyboard(it) }
    }

    private fun setObservers() {
        viewModel.countries.observe(viewLifecycleOwner, { countries ->
            countriesAdapter.filteredList = countries
            viewPager.adapter = RegionsAdapter(this, viewModel.regions!!)
        })
    }

    private fun regionSelector() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding?.countriesFragmentSearchEt?.text?.clear()
                binding?.countriesFragmentKeyboardBtn?.performClick()
                val countries = viewModel.countries.value
                val filter = viewModel.regions?.get(position)
                countriesAdapter.filteredList = when (filter) {
                    ALL -> countries
                    OTHER -> countries!!.filter { country -> country.region.isNullOrBlank() }
                    else -> countries!!.filter { country -> country.region.equals(filter) }
                }
            }
        })
    }


    private fun searchListener() {
        binding?.countriesFragmentSearchEt?.doOnTextChanged { text, _, _, _ ->
            val search = if (text?.equals(" ") == true) "" else text.toString()
            countriesAdapter.searchFilter(search)
        }
    }

    private fun onCountryClick(country: Country?) {
        activity?.hideKeyboard(_binding?.root!!)
        val action = CountriesFragmentDirections.actionCountriesFragmentToCountryFragment()
        action.country = country
        this.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
