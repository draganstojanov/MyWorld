package com.andraganoid.myworld.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.andraganoid.myworld.databinding.CountryFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARG_COUNTRY_NAME
import org.koin.android.viewmodel.ext.android.viewModel

class CountryFragment : Fragment() {

    private var _binding: CountryFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CountryViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CountryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        arguments?.takeIf { it.containsKey(ARG_COUNTRY_NAME) }?.apply {
            viewModel.getCountry(getString(ARG_COUNTRY_NAME).toString())
        }

    }

    private fun setObservers() {
        viewModel.country.observe(viewLifecycleOwner, Observer {
            showData(it)
        })
        viewModel.borders.observe(viewLifecycleOwner, Observer {
            showBorders(it)
        })
    }

    private fun showData(country: Country) {
        Toast.makeText(activity, country.name, Toast.LENGTH_SHORT).show()
    }

    private fun showBorders(borders: List<Country>) {
        Toast.makeText(activity, borders.size.toString(), Toast.LENGTH_SHORT).show()
    }

}
