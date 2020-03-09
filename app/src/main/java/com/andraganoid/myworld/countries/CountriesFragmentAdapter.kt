package com.andraganoid.myworld.countries

import android.app.Activity
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andraganoid.myworld.databinding.CountriesItemBinding
import com.andraganoid.myworld.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class CountriesFragmentAdapter(private val activity: Activity) : RecyclerView.Adapter<CountriesFragmentAdapter.CountriesViewHolder>() {

    var filteredList: List<Country> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesViewHolder {
//        val view=LayoutInflater.from(parent.context).inflate(R.layout.countries_item,false)

        val binding = CountriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountriesViewHolder(binding)

    }

    override fun getItemCount(): Int = filteredList.size

    override fun onBindViewHolder(holder: CountriesViewHolder, position: Int) = holder.bind(filteredList.get(position))


    inner class CountriesViewHolder(private val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
            binding.countriesItemNameTv.text = country.name
            binding.countriesItemNativeNameTv.text = country.nativeName
            //   binding.countriesItemFlagIv.load("https://img.etimg.com/thumb/width-640,height-480,imgsize-182458,resizemode-1,msid-58980445/some-fun-facts-about-disneys-most-popular-character-donald-duck.jpg")
            GlideToVectorYou.justLoadImage(activity, Uri.parse(country.flag), binding.countriesItemFlagIv)

            Log.d("aadaptter", country.flag.toString())
        }
    }


}



