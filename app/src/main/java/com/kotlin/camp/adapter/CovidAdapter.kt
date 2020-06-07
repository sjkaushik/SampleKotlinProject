package com.kotlin.camp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.camp.databinding.ItemCovidListBinding
import com.kotlin.camp.model.Covid

class CovidAdapter(
    private var covid: ArrayList<Covid>,
    var selectCovid: (Covid, Int) -> Unit
) : RecyclerView.Adapter<CovidAdapter.ItemViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CovidAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCovidListBinding.inflate(inflater)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return covid.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind(covid[holder.adapterPosition])
        holder.itemView.setOnClickListener {
            selectCovid(covid[holder.adapterPosition], holder.adapterPosition)
        }
    }

    class ItemViewHolder(private val binding: ItemCovidListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Covid) {
            binding.itemViewModel = item
            binding.executePendingBindings()
        }


    }

}



