package com.andraganoid.myworld.country.borders

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.R
import com.andraganoid.myworld.databinding.CountriesItemBinding
import com.andraganoid.myworld.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class BordersAdapter(private val borders: List<Country>, private val fragment: BordersFragment) :
    RecyclerView.Adapter<BordersAdapter.BordersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BordersViewHolder {
        val binding = CountriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BordersViewHolder(binding)
    }

    override fun getItemCount(): Int = borders.size

    override fun onBindViewHolder(holder: BordersViewHolder, position: Int) = holder.bind(borders.get(position))

    inner class BordersViewHolder(private val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
//            GlideToVectorYou.justLoadImage(fragment.activity, Uri.parse(country.flag), binding.countriesItemFlagIv)
            GlideToVectorYou
                .init()
                .with(fragment.activity)
                .setPlaceHolder(R.drawable.ic_flag, R.drawable.ic_flag)
                .load(Uri.parse(country.flag), binding.countriesItemFlagIv)
            binding.root.setOnClickListener { fragment.onCountryClick(borders.get(adapterPosition)) }
        }
    }
}