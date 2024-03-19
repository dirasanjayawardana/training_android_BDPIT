package com.fazztrack.bcasyariah.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fazztrack.bcasyariah.adapter.ListTransactionAdapter
import com.fazztrack.bcasyariah.databinding.FragmentAdminBinding
import com.fazztrack.bcasyariah.databinding.FragmentDashboardBinding
import com.fazztrack.bcasyariah.model.TransactionModel
import com.fazztrack.bcasyariah.presentation.DetailTransactionActivity

// fragment bisa ditampilkan di activity, satu activity bisa memiliki banyak fragment
// tinggal diatur saja fragment mana yang mau ditampilkan dipaling depan

class AdminFragment : Fragment() {

    // membuat binding yg mutable
    private var _binding: FragmentAdminBinding? = null
    // membuat binding tidak nullable
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAdminBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    // untuk memanggil variabel tanpa membuat object atau memanggil class
    companion object{
        const val TRANSACTION_KEY = "transaction_key"
    }

}