package com.kotlin.camp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.camp.databinding.ItemCountriesListBinding
import com.kotlin.camp.model.Country

class CountryAdapter(
    private var countries: ArrayList<Country>,
    var selectCountry: (Country, Int) -> Unit
) : RecyclerView.Adapter<CountryAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCountriesListBinding.inflate(inflater)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind(countries[holder.adapterPosition])
        holder.itemView.setOnClickListener {
            selectCountry(countries[holder.adapterPosition], holder.adapterPosition)
        }
    }

    class ItemViewHolder(private val binding: ItemCountriesListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Country) {
            binding.itemViewModel = item
            binding.executePendingBindings()
        }


    }

}



