package com.fazztrack.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fazztrack.bcasyariah.databinding.ItemAccountBalanceBinding
import com.fazztrack.bcasyariah.databinding.ItemPromoBinding
import com.fazztrack.bcasyariah.model.PromoModel

class PromoAdapter(private val data: List<PromoModel>) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {

    inner class PromoViewHolder(val binding: ItemPromoBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: PromoModel){
            binding.imagePromo.setImageResource(data.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        return PromoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
       holder.bind(data[position])
    }

}