package com.andraganoid.myworld.country.regional

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.LanguageItemBinding
import com.andraganoid.myworld.databinding.RegionalItemBinding
import com.andraganoid.myworld.model.LanguagesItem
import com.andraganoid.myworld.model.RegionalBlocsItem

class RegionalAdapter(private val regionalBlocks: List<RegionalBlocsItem?>?) : RecyclerView.Adapter<RegionalAdapter.RegionalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegionalViewHolder {
        val binding = RegionalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RegionalViewHolder(binding)
    }

    override fun getItemCount(): Int = regionalBlocks!!.size

    override fun onBindViewHolder(holder: RegionalViewHolder, position: Int) = holder.bind(regionalBlocks?.get(position)!!)

    inner class RegionalViewHolder(private val binding: RegionalItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(regionalBlocsItem: RegionalBlocsItem) {

            binding.regionalItem = regionalBlocsItem
            binding.executePendingBindings()
        }
    }
}