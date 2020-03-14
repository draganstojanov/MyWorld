package com.andraganoid.myworld.country.borders

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.BordersItemBinding
import com.andraganoid.myworld.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class BordersAdapter(private val borders: List<Country>, private val fragment: BordersFragment) :
    RecyclerView.Adapter<BordersAdapter.BordersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BordersViewHolder {
        val binding = BordersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BordersViewHolder(binding)
    }

    override fun getItemCount(): Int = borders.size

    override fun onBindViewHolder(holder: BordersViewHolder, position: Int) = holder.bind(borders.get(position))

    inner class BordersViewHolder(private val binding: BordersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.country = country
            GlideToVectorYou.justLoadImage(fragment.activity, Uri.parse(country.flag), binding.bordersItemFlagIv)
            binding.root.setOnClickListener { fragment.onCountryClick(borders.get(adapterPosition)) }
        }
    }
}