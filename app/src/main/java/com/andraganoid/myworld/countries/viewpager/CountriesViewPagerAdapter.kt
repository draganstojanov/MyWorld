package com.andraganoid.myworld.countries.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andraganoid.myworld.utils.ARG_REGION

class CountriesViewPagerAdapter(fragment: Fragment, private val regionList: List<String>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = regionList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = CountriesViewPagerFragment()
        fragment.arguments = Bundle().apply {
            putString(ARG_REGION, regionList.get(position))
        }
        return fragment
    }
}