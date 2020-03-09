package com.andraganoid.myworld.countries

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.andraganoid.myworld.countries.viewpager.CountriesViewPagerAdapter
import com.andraganoid.myworld.databinding.CountriesFragmentBinding
import com.andraganoid.myworld.utils.ALL
import com.andraganoid.myworld.utils.OTHER
import org.koin.android.viewmodel.ext.android.viewModel


class CountriesFragment : Fragment() {

    private var _binding: CountriesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CountriesViewModel by viewModel()
    private lateinit var countriesAdapter: CountriesFragmentAdapter
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CountriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = binding.countriesFragmentViewPager
        countriesAdapter = CountriesFragmentAdapter(activity!!)
        binding.countriesRecView.adapter = countriesAdapter
        setObservers()
        regionSelector()
        searchListener()
    }

    private fun setObservers() {
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
            countriesAdapter.filteredList = countries
            viewPager.adapter = CountriesViewPagerAdapter(this, viewModel.regions!!)
        })
    }

    private fun regionSelector() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
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
        binding.countriesFragmentSearchEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val search = if (s!!.equals(" ")) "" else s.toString()
                countriesAdapter.searchFilter(search)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
