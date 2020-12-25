package com.andraganoid.myworld.countries.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andraganoid.myworld.databinding.RegionsFragmentBinding
import com.andraganoid.myworld.utils.ARGS_REGION
import com.andraganoid.myworld.utils.ARGS_REGION_POS
import com.andraganoid.myworld.utils.MAX
import com.andraganoid.myworld.utils.MIN

class RegionsFragment : Fragment() {

    private var _binding: RegionsFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = RegionsFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARGS_REGION) }?.apply {
            binding?.countriesViewPagerFragmentRegionTv?.text = getString(ARGS_REGION)
            val pos = getInt(ARGS_REGION_POS)
            binding?.arrowLeft?.visibility = if (pos == MIN) View.INVISIBLE else View.VISIBLE
            binding?.arrowRight?.visibility = if (pos == MAX) View.INVISIBLE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
