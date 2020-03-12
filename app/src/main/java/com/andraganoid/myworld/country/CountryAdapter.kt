package com.andraganoid.myworld.country

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY

class CountryAdapter(
    fragment: Fragment,
    private val country: Country,
    private val countryInfoList: ArrayList<Fragment>
) : FragmentStateAdapter(fragment) {

//    var countryInfoList: List<Fragment> = emptyList()
//        set(value) {
//            field = value
//        }

    override fun getItemCount(): Int = countryInfoList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = countryInfoList.get(position)
        fragment.arguments = Bundle().apply { putSerializable(ARGS_COUNTRY, country) }
        return fragment
    }
}