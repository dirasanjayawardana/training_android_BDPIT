package com.fazztrack.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fazztrack.bcasyariah.databinding.ItemAccountBalanceBinding
import com.fazztrack.bcasyariah.model.AccountBalanceModel

class AccountBalanceAdapter(private val data: List<AccountBalanceModel>) :
    RecyclerView.Adapter<AccountBalanceAdapter.AccountBalanceViewHolder>() {

    inner class AccountBalanceViewHolder(val binding: ItemAccountBalanceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AccountBalanceModel) {
            binding.typeSaving.text = data.savingType
            binding.noRek.text = data.noRek.toString()
            binding.amountBalance.text = data.balanceAmount
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountBalanceViewHolder {
        return AccountBalanceViewHolder(
            ItemAccountBalanceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: AccountBalanceViewHolder, position: Int) {
        holder.bind(data[position])
    }
}