package com.fazztrack.bcasyariah.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.ActivityDetailTransactionBinding
import com.fazztrack.bcasyariah.model.TransactionModel
import com.fazztrack.bcasyariah.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // menangkap data yang dilempar dari ListTransactionActivity
        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)

        binding.textTransactionType.text = transaction?.transferType
        binding.textAmountTransaction.text = transaction?.amount.toString()
        binding.textTransferDestination.text = transaction?.transferDestination
        binding.textDateTransaction.text = transaction?.date
        binding.textStatusTransaction.text = transaction?.transferStatus
    }
}