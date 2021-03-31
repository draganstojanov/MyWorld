package com.andraganoid.myworld.country

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.andraganoid.myworld.MainActivity
import com.andraganoid.myworld.R
import com.andraganoid.myworld.country.borders.BordersFragment
import com.andraganoid.myworld.country.codes.CodesFragment
import com.andraganoid.myworld.country.currency.CurrencyFragment
import com.andraganoid.myworld.country.general.GeneralFragment
import com.andraganoid.myworld.country.language.LanguageFragment
import com.andraganoid.myworld.country.regional.RegionalFragment
import com.andraganoid.myworld.databinding.CountryFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import com.andraganoid.myworld.utils.svgImageLoader
import com.google.android.material.tabs.TabLayoutMediator

class CountryFragment : Fragment() {

    private lateinit var binding: CountryFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CountryFragmentBinding.inflate(inflater, container, false)
        prepare()
        return binding.root
    }

    private fun prepare() {
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply { showData(getSerializable(ARGS_COUNTRY) as Country) }
        binding.backBtn.setOnClickListener { (activity as MainActivity).onBackPressed() }
    }

    private fun showData(country: Country) {
        binding.country = country
        binding.countryFragmentFlagIv.load(Uri.parse(country.flag), requireContext().svgImageLoader) {
            placeholder(R.drawable.ic_flag)
            fallback(R.drawable.ic_flag)
        }

        val border = BordersFragment()
        val regional = RegionalFragment()
        val countryInfoList =
            arrayListOf<Fragment>(GeneralFragment(), CodesFragment(), border, CurrencyFragment(), LanguageFragment(), regional)
        if (country.borders?.size == 0) {
            countryInfoList.remove(border)
        }
        if (country.regionalBlocs?.size == 0) {
            countryInfoList.remove(regional)
        }
        binding.countryInfoVp.adapter = CountryAdapter(this, country, countryInfoList)
        TabLayoutMediator(binding.countryInfoTabs, binding.countryInfoVp) { tab, position ->
            val tabText = countryInfoList[position].javaClass.simpleName.replace("Fragment", "")
            tab.text = if (tabText == "regional") "$tabText blocks" else tabText
        }.attach()
    }
}
