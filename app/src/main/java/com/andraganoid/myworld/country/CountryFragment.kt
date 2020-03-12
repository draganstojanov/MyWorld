package com.andraganoid.myworld.country

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.andraganoid.myworld.country.borders.BordersFragment
import com.andraganoid.myworld.country.codes.CodesFragment
import com.andraganoid.myworld.country.currency.CurrencyFragment
import com.andraganoid.myworld.country.general.GeneralFragment
import com.andraganoid.myworld.country.language.LanguageFragment
import com.andraganoid.myworld.country.regional.RegionalFragment
import com.andraganoid.myworld.databinding.CountryFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY_NAME
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.country_fragment.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CountryFragment : Fragment() {

    private lateinit var binding: CountryFragmentBinding
    private val viewModel: CountryViewModel by sharedViewModel()
    private val countryInfoList = arrayListOf<Fragment>(
        GeneralFragment(), CodesFragment(), BordersFragment(), CurrencyFragment(), LanguageFragment(), RegionalFragment()
    )
    private lateinit var countryAdapter: CountryAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CountryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY_NAME) }?.apply {
            viewModel.getCountry(getString(ARGS_COUNTRY_NAME).toString())
        }
    }


    private fun setObservers() {
        viewModel.country.observe(viewLifecycleOwner, Observer { country ->
            if (country != null) {
                showData(country)
            }
        })
        viewModel.borders.observe(viewLifecycleOwner, Observer {
            showBorders(it)
        })
    }

    private fun showData(country: Country) {
        binding.country = viewModel.country.value
        GlideToVectorYou.justLoadImage(activity, Uri.parse(country.flag), countryFragmentFlagIv)
        if (country.borders?.size == 0) {
            countryInfoList.remove(BordersFragment())
        }
        if (country.regionalBlocs?.size == 0) {
            countryInfoList.remove(BordersFragment())
        }
        countryInfoVp.adapter = CountryAdapter(this, country, countryInfoList)
        TabLayoutMediator(countryInfoTabs, countryInfoVp) { tab, position ->
            val tabText = countryInfoList.get(position).javaClass.simpleName.replace("Fragment", "")
            Toast.makeText(activity, tabText, Toast.LENGTH_SHORT).show()
            tab.text = tabText
        }.attach()
    }

    private fun showBorders(borders: List<Country>) {
        Toast.makeText(activity, borders.size.toString(), Toast.LENGTH_SHORT).show()
    }


//    viewPager.adapter = SignUpAdapter(this)
//
//    TabLayoutMediator(tabs, viewPager) { tab, position ->
//        tab.text = tabTitle.get(position)
//    }.attach()

}
