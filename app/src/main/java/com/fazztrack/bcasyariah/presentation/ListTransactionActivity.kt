package com.fazztrack.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fazztrack.bcasyariah.adapter.ListTransactionAdapter
import com.fazztrack.bcasyariah.databinding.ActivityListTransactionBinding
import com.fazztrack.bcasyariah.model.TransactionModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTransactionActivity: AppCompatActivity() {

    private lateinit var binding: ActivityListTransactionBinding

    private var listTransactionAdaptor = ListTransactionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListTransaction.adapter = listTransactionAdaptor
        listTransactionAdaptor.setData(createDummyListTransaction())
        listTransactionAdaptor.setOnClickTransaction { transaction ->
            navigateToDetailTransaction(transaction)
        }
    }

    private fun navigateToDetailTransaction(data: TransactionModel){
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY, data)
        startActivity(intent)
    }

    // membuat data dummy, mengembalikan data dengan bentuk transactionMOdel dalam bentuklist
    private fun createDummyListTransaction() : MutableList<TransactionModel>{
        return mutableListOf(
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR ABC",
                date = "23/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BCA",
                transferDestination = "BCA 101294382",
                date = "25/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BNI",
                transferDestination = "BNI 101294382",
                date = "27/01/24",
                transferStatus = "Failed",
                amount = 100000.0
            ), TransactionModel(
                transferType = "TopUp DANA",
                transferDestination = "BANA 08121234345678",
                date = "05/02/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR ABC",
                date = "23/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BCA",
                transferDestination = "BCA 101294382",
                date = "25/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BNI",
                transferDestination = "BNI 101294382",
                date = "27/01/24",
                transferStatus = "Failed",
                amount = 100000.0
            ), TransactionModel(
                transferType = "TopUp DANA",
                transferDestination = "BANA 08121234345678",
                date = "05/02/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR ABC",
                date = "23/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BCA",
                transferDestination = "BCA 101294382",
                date = "25/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BNI",
                transferDestination = "BNI 101294382",
                date = "27/01/24",
                transferStatus = "Failed",
                amount = 100000.0
            ), TransactionModel(
                transferType = "TopUp DANA",
                transferDestination = "BANA 08121234345678",
                date = "05/02/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "QR ABC",
                date = "23/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BCA",
                transferDestination = "BCA 101294382",
                date = "25/01/24",
                transferStatus = "Success",
                amount = 100000.0
            ), TransactionModel(
                transferType = "Transfer BNI",
                transferDestination = "BNI 101294382",
                date = "27/01/24",
                transferStatus = "Failed",
                amount = 100000.0
            ), TransactionModel(
                transferType = "TopUp DANA",
                transferDestination = "BANA 08121234345678",
                date = "05/02/24",
                transferStatus = "Success",
                amount = 100000.0
            ),
        )
    }

    // untuk memanggil variabel tanpa membuat object atau memanggil class
    companion object{
        const val TRANSACTION_KEY = "transaction_key"
    }

}