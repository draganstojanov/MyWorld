package com.andraganoid.myworld.countries

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.R
import com.andraganoid.myworld.databinding.CountriesItemBinding
import com.andraganoid.myworld.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import java.util.*

class CountriesAdapter(private val countryClick: (Country) -> Unit) :
    RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder>() {
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
        }

    fun searchFilter(search: String) {
        finalListSet(filteredList?.filter { country ->
            country.name?.toLowerCase(Locale.getDefault())!!
                .contains(search.toLowerCase(Locale.getDefault())) || country.nativeName?.toLowerCase(Locale.getDefault())!!
                .contains(search.toLowerCase(Locale.getDefault()))
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
            binding.country = country
            GlideToVectorYou
                .init()
                .with(binding.root.context)
                .setPlaceHolder(R.drawable.ic_flag, R.drawable.ic_flag)
                .load(Uri.parse(country.flag), binding.countriesItemFlagIv)
            binding.root.setOnClickListener { countryClick.invoke(finalList?.get(adapterPosition)!!) }
        }
    }


}



