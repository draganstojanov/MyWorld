package com.andraganoid.myworld.countries

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.andraganoid.myworld.R
import com.andraganoid.myworld.countries.regions.RegionsAdapter
import com.andraganoid.myworld.utils.ALL
import com.andraganoid.myworld.utils.OTHER
import com.andraganoid.myworld.utils.hideKeyboard
import kotlinx.android.synthetic.main.countries_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class CountriesFragment : Fragment() {

    private val viewModel: CountriesViewModel by viewModel()
    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.countries_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = countriesFragmentViewPager
        countriesAdapter = CountriesAdapter(this)
        countriesRecView.adapter = countriesAdapter
        setObservers()
        regionSelector()
        searchListener()
        countriesFragmentKeyboardBtn.setOnClickListener { view ->
            hideKeyboard(context!!, view)
        }
    }

    private fun setObservers() {
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries ->

//            val counter1 = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
//            val counter2 = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
//            val x9 = 0
//            val x10 = 0
//            countries.forEach { country ->
//
//                Log.d("CCOUNTT", country.name+"***"+country.callingCodes+"***"+country.numericCode+"***"+country.topLevelDomain)
//


            ///    val c1 = country.borders!!.size
            //    counter1[c1]++
//                if (c1 == 9) {
//                    Log.d("CCOUNTT=x1", country.currencies.toString())
//                }
            //    val c2 = country.regionalBlocs!!.size
           //     counter2[c2]++
//                if (c2 == 10) {
//                    Log.d("CCOUNTT=x2", country.languages.toString())
//                }
//            }
//            Log.d("CCOUNTT=1", counter1.toString())
//            Log.d("CCOUNTT=2", counter2.toString())







            countriesAdapter.filteredList = countries
            viewPager.adapter = RegionsAdapter(this, viewModel.regions!!)
        })
    }

    private fun regionSelector() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                countriesFragmentSearchEt.text.clear()
                countriesFragmentKeyboardBtn.performClick()
                val countries = viewModel.countries.value
                val filter = viewModel.regions?.get(position)
                countriesAdapter.filteredList = when (filter) {
                    ALL -> countries
                    OTHER -> countries!!.filter { country -> country.region.isNullOrBlank() }
                    else -> countries!!.filter { country -> country.region.equals(filter) }
                }
            }
        })
    }

    private fun searchListener() {
        countriesFragmentSearchEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val search = if (s!!.equals(" ")) "" else s.toString()
                countriesAdapter.searchFilter(search)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    fun onCountryClick(name: String?) {
        hideKeyboard(context!!,view!!)
        val action = CountriesFragmentDirections.actionCountriesFragmentToCountryFragment()
        action.countryName = name
        findNavController().navigate(action)
    }

}
