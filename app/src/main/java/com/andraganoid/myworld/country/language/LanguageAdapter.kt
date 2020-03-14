package com.andraganoid.myworld.country.language

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.LanguageItemBinding
import com.andraganoid.myworld.model.LanguagesItem

class LanguageAdapter(private val languages: List<LanguagesItem?>?) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val binding = LanguageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LanguageViewHolder(binding)
    }

    override fun getItemCount(): Int = languages!!.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) = holder.bind(languages?.get(position)!!)

    inner class LanguageViewHolder(private val binding: LanguageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(language: LanguagesItem) {


            Log.d("LLANNGG",language.toString())

            binding.languageItem = language
            binding.executePendingBindings()
        }
    }
}