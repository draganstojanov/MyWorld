package com.andraganoid.myworld.country.borders

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.andraganoid.myworld.R
import com.andraganoid.myworld.databinding.CountriesItemBinding
import com.andraganoid.myworld.model.Country
import com.andraganoid.myworld.utils.svgImageLoader

class BordersAdapter(private val borders: List<Country>, private val countryClick: (Country) -> Unit) :
    RecyclerView.Adapter<BordersAdapter.BordersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BordersViewHolder {
        val binding = CountriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BordersViewHolder(binding)
    }

    override fun getItemCount(): Int = borders.size

    override fun onBindViewHolder(holder: BordersViewHolder, position: Int) = holder.bind(borders[position])

    inner class BordersViewHolder(private val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            binding.countriesItemFlagIv.load(Uri.parse(country.flag), binding.root.context.svgImageLoader) {
                placeholder(R.drawable.ic_flag)
                fallback(R.drawable.ic_flag)
            }
            binding.root.setOnClickListener { countryClick.invoke(borders[layoutPosition]) }
            binding.executePendingBindings()
        }
    }
}