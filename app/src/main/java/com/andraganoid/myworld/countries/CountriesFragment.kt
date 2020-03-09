package com.andraganoid.myworld.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.andraganoid.myworld.databinding.CountriesFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel


class CountriesFragment : Fragment() {

    private var _binding: CountriesFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CountriesViewModel by viewModel()
    private lateinit var adapter: CountriesFragmentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CountriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter=CountriesFragmentAdapter(activity!!)
        binding.countriesRecView.adapter = adapter
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->
            adapter.filteredList = countries
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
