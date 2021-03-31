package com.andraganoid.myworld.country.language

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.LanguageFragmentBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY


class LanguageFragment : Fragment() {

    private var _binding: LanguageFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = LanguageFragmentBinding.inflate(inflater, container, false)
        arguments?.takeIf { it.containsKey(ARGS_COUNTRY) }?.apply {
            binding?.languageRecView?.adapter = LanguageAdapter((arguments?.getSerializable(ARGS_COUNTRY) as Country).languages)
        }
        return _binding!!.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





