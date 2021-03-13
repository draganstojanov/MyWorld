package com.andraganoid.myworld.country.codes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.CodesFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY

class CodesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = CodesFragmentBinding.inflate(inflater, container, false)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            binding.country = getSerializable(ARGS_COUNTRY) as Country
        }
        return binding.root
    }

}
