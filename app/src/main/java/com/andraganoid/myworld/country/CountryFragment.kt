package com.andraganoid.myworld.country

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.MainActivity
import com.andraganoid.myworld.country.borders.BordersFragment
import com.andraganoid.myworld.country.codes.CodesFragment
import com.andraganoid.myworld.country.currency.CurrencyFragment
import com.andraganoid.myworld.country.general.GeneralFragment
import com.andraganoid.myworld.country.language.LanguageFragment
import com.andraganoid.myworld.country.regional.RegionalFragment
import com.andraganoid.myworld.databinding.CountryFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.country_fragment.*

class CountryFragment : Fragment() {

    private lateinit var binding: CountryFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CountryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            showData(getSerializable(ARGS_COUNTRY) as Country)
        }
        backBtn.setOnClickListener{
            (activity as MainActivity).onBackPressed()
        }
    }

    private fun showData(country: Country) {
        binding.country = country
        GlideToVectorYou.justLoadImage(activity, Uri.parse(country.flag), countryFragmentFlagIv)
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
        countryInfoVp.adapter = CountryAdapter(this, country, countryInfoList)
        TabLayoutMediator(countryInfoTabs, countryInfoVp) { tab, position ->
            val tabText = countryInfoList.get(position).javaClass.simpleName.replace("Fragment", "")
            Toast.makeText(activity, tabText, Toast.LENGTH_SHORT).show()
            tab.text = tabText
        }.attach()
    }

}
