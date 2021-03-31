package com.andraganoid.myworld.country.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.CurrencyFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY


class CurrencyFragment : Fragment() {

    private var _binding: CurrencyFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = CurrencyFragmentBinding.inflate(inflater, container, false)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            binding?.currencyRecView?.adapter = CurrencyAdapter((arguments?.getSerializable(ARGS_COUNTRY) as Country).currencies)
        }
        return _binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
