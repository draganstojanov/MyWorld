package com.andraganoid.myworld.countries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andraganoid.myworld.databinding.CountriesFragmentBinding
import javax.inject.Inject

class CountriesFragment : Fragment() {

    private var _binding: CountriesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CountriesViewModel

    @Inject
    lateinit var factory: CountriesViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(CountriesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CountriesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.aaa.observe(viewLifecycleOwner, Observer {
            binding.message.text = it.toString()
        })
        binding.clickBtn.setOnClickListener {
            viewModel.aaa.value = viewModel.aaa.value!! + 1
            Toast.makeText(activity, viewModel.aaa.value.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
