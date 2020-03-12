package com.andraganoid.myworld.country.codes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.andraganoid.myworld.R

class CodesFragment : Fragment() {

    companion object {
        fun newInstance() = CodesFragment()
    }

    private lateinit var viewModel: CodesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.codes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CodesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
