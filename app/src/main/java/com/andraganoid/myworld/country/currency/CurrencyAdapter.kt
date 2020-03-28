package com.andraganoid.myworld.country.currency

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.CurrencyItemBinding
import com.andraganoid.myworld.model.CurrenciesItem

class CurrencyAdapter(private val currencies: List<CurrenciesItem?>?) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding = CurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun getItemCount(): Int = currencies!!.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) = holder.bind(currencies?.get(position)!!)

    inner class CurrencyViewHolder(private val binding: CurrencyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: CurrenciesItem) {
            binding.currencyItem = currency
            binding.divider = currencies?.size != adapterPosition + 1
            binding.executePendingBindings()
        }
    }
}