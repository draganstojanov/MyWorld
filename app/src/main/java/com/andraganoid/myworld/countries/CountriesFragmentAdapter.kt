package com.andraganoid.myworld.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.CountriesItemBinding
import com.andraganoid.myworld.model.Country

class CountriesFragmentAdapter() : RecyclerView.Adapter<CountriesViewHolder>() {

    var filteredList: List<Country> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
//        val view=LayoutInflater.from(parent.context).inflate(R.layout.countries_item,false)

        val binding = CountriesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CountriesViewHolder(binding)

    }

    override fun getItemCount(): Int = filteredList.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) = holder.bind(filteredList.get(position))
}

class CountriesViewHolder(private val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(country: Country) {
        binding.countriesItemNameTv.text = country.name
    }
}
