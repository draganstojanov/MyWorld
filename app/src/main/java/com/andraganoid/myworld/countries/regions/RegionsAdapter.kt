package com.andraganoid.myworld.countries.regions

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.andraganoid.myworld.utils.ARGS_REGION

class RegionsAdapter(fragment: Fragment, private val regionList: List<String>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = regionList.size

    override fun createFragment(position: Int): Fragment {
        val fragment = RegionsrFragment()
        fragment.arguments = Bundle().apply { putString(ARGS_REGION, regionList.get(position)) }
        return fragment
    }
}