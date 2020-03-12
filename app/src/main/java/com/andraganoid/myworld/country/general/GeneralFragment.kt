package com.andraganoid.myworld.country.general

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.andraganoid.myworld.R

class GeneralFragment : Fragment() {

    companion object {
        fun newInstance() = GeneralFragment()
    }

    private lateinit var viewModel: GeneralViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.general_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GeneralViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
