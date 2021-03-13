package com.andraganoid.myworld.country.borders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.andraganoid.myworld.R
import com.andraganoid.myworld.databinding.BordersFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import org.koin.android.ext.android.inject


class BordersFragment : Fragment() {

    private var _binding: BordersFragmentBinding? = null
    private val binding get() = _binding
    private val viewModel: BordersViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = BordersFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.borders.observe(viewLifecycleOwner, { borders ->
            binding?.bordersRecView?.adapter = BordersAdapter(borders, this::onCountryClick)
        })
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            viewModel.getBorders(getSerializable(ARGS_COUNTRY) as Country)
        }
    }

    private fun onCountryClick(country: Country) {
        val bundle = Bundle().apply { putSerializable(ARGS_COUNTRY, country) }
        val navOptions: NavOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
        view?.findNavController()?.navigate(R.id.countryFragment, bundle, navOptions)
    }


}
