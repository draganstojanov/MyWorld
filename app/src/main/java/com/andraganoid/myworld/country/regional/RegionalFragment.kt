package com.andraganoid.myworld.country.regional

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.RegionalFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY


class RegionalFragment : Fragment() {

    private var _binding: RegionalFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RegionalFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.regionalRecView?.adapter = RegionalAdapter((arguments?.getSerializable(ARGS_COUNTRY) as Country).regionalBlocs)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
