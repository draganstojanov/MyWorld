package com.andraganoid.myworld.country.regional

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.andraganoid.myworld.R

class RegionalFragment : Fragment() {

    companion object {
        fun newInstance() = RegionalFragment()
    }

    private lateinit var viewModel: RegionalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.regional_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegionalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}