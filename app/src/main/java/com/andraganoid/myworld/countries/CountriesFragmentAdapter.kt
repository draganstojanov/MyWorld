package com.andraganoid.myworld.countries

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.CountriesItemBinding
import com.andraganoid.myworld.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountriesFragmentAdapter(private val fragment: CountriesFragment) :
    RecyclerView.Adapter<CountriesFragmentAdapter.CountriesViewHolder>() {
    var finalList: ArrayList<Country>? = arrayListOf()

    private fun finalListSet(fList: List<Country>?) {
        finalList?.clear()
        finalList?.addAll(fList!!)
        notifyDataSetChanged()
    }

    var filteredList: List<Country>? = emptyList()
        set(value) {
            field = value
            finalListSet(filteredList)
            // notifyDataSetChanged()
        }

    fun searchFilter(search: String) {
        finalListSet(filteredList?.filter { country ->
            country.name?.toLowerCase()!!.contains(search.toLowerCase()) || country.nativeName?.toLowerCase()!!
                .contains(search.toLowerCase())
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {

        val binding = CountriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(binding)

    }

    override fun getItemCount(): Int = finalList!!.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) = holder.bind(finalList!!.get(position))

    inner class CountriesViewHolder(private val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.countriesItemNameTv.text = country.name
            binding.countriesItemNativeNameTv.text = country.nativeName
            GlideToVectorYou.justLoadImage(fragment.activity, Uri.parse(country.flag), binding.countriesItemFlagIv)
            binding.root.setOnClickListener{
               fragment.onCountryClick(finalList?.get(adapterPosition)?.name)
            }
        }
    }


}



