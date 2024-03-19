package com.fazztrack.bcasyariah.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fazztrack.bcasyariah.databinding.ItemListTransactionBinding
import com.fazztrack.bcasyariah.model.TransactionModel

// list adapter (untuk mengelola tampilan)

class ListTransactionAdapter: RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>() {

    // tanda _ diawal nama variabel menandakan bahwa variabel tersebut adalah mutable variabel
    private var _data: MutableList<TransactionModel> = mutableListOf()

    // -> Unit artinya tidak return apa-apa atau void
    private var _onClickTransaction: (TransactionModel) -> Unit = {}

    fun setData(newData: MutableList<TransactionModel>){
        _data = newData
        notifyDataSetChanged()
    }

    fun setOnClickTransaction(listener: (TransactionModel)-> Unit){
        _onClickTransaction = listener
    }

    inner class TransactionViewHolder(private val binding: ItemListTransactionBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: TransactionModel, onClickTransaction: (TransactionModel) -> Unit){
            binding.textStatusTransaction.text = item.transferStatus
            binding.textTransferType.text = item.transferType
            binding.textDateTransaction.text = item.date
            binding.textAmountTransaction.text = item.amount.toString()
            binding.textTransferDestination.text = item.transferDestination

            // invoke untuk memberi callback
            binding.root.setOnClickListener{ onClickTransaction.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(ItemListTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    // tanda = di function sama seperti return
    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position], _onClickTransaction)
    }

}