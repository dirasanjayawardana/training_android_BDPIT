package com.fazztrack.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.FragmentDashboardBinding
import com.fazztrack.bcasyariah.model.MenuDashboardModel
import com.fazztrack.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter

// fragment bisa ditampilkan di activity, satu activity bisa memiliki banyak fragment
// tinggal diatur saja fragment mana yang mau ditampilkan dipaling depan

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(),
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener{_, _,position, _ ->
        Toast.makeText(
            binding.root.context,
            populateDataMenu()[position].menuName,
            Toast.LENGTH_SHORT
        ).show()}
    }

    private fun populateDataMenu() : List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.menu1,
                menuName = "Transfer"
            ), MenuDashboardModel(
                image = R.drawable.menu2,
                menuName = "Pembelian"
            ), MenuDashboardModel(
                image = R.drawable.menu3,
                menuName = "Pembayaran"
            ), MenuDashboardModel(
                image = R.drawable.menu4,
                menuName = "Cardless"
            ), MenuDashboardModel(
                image = R.drawable.menu5,
                menuName = "History Transaksi"
            ), MenuDashboardModel(
                image = R.drawable.menu6,
                menuName = "Mutasi Rekening"
            ), MenuDashboardModel(
                image = R.drawable.menu7,
                menuName = "Jadwal Sholat"
            ),
        )
    }

}