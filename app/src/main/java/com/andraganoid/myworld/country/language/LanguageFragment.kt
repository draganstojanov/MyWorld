package com.andraganoid.myworld.country.language

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.R
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.ARGS_COUNTRY
import kotlinx.android.synthetic.main.language_fragment.*

class LanguageFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.language_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        languageRecView.adapter = LanguageAdapter((arguments?.getSerializable(ARGS_COUNTRY) as Country).languages)
    }

}



