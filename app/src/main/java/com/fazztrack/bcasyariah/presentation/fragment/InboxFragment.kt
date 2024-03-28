package com.fazztrack.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fazztrack.bcasyariah.databinding.FragmentDashboardBinding
import com.fazztrack.bcasyariah.databinding.FragmentInboxBinding
import com.fazztrack.bcasyariah.adapter.ListTransactionAdapter
import com.fazztrack.bcasyariah.model.TransactionModel
import dagger.hilt.android.AndroidEntryPoint

// fragment bisa ditampilkan di activity, satu activity bisa memiliki banyak fragment
// tinggal diatur saja fragment mana yang mau ditampilkan dipaling depan

@AndroidEntryPoint
class InboxFragment : Fragment() {

    // membuat binding yg mutable
    private var _binding: FragmentInboxBinding? = null
    // membuat binding tidak nullable
    private val binding get() = _binding!!

    private var listTransactionAdaptor = ListTransactionAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)

        binding.rvListTransaction.adapter = listTransactionAdaptor
        listTransactionAdaptor.setData(createDummyListTransaction())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

}