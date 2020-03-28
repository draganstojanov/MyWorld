package com.andraganoid.myworld.country.borders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import kotlinx.android.synthetic.main.borders_fragment.*
import org.koin.android.ext.android.inject


class BordersFragment : Fragment() {

    private val viewModel: BordersViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.borders_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.borders.observe(viewLifecycleOwner, Observer { borders ->
            bordersRecView.adapter = BordersAdapter(borders, this)
        })
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            viewModel.getBorders(getSerializable(ARGS_COUNTRY) as Country)
        }
    }

    fun onCountryClick(country: Country) {
        val bundle = Bundle().apply { putSerializable(ARGS_COUNTRY, country) }
        val navOptions: NavOptions = NavOptions.Builder().setLaunchSingleTop(true).build()
        view?.findNavController()?.navigate(R.id.countryFragment, bundle, navOptions)
    }


}
