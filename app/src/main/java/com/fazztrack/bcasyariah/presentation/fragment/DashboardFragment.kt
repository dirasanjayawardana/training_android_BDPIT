package com.fazztrack.bcasyariah.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.databinding.FragmentDashboardBinding

// fragment bisa ditampilkan di activity, satu activity bisa memiliki banyak fragment
// tinggal diatur saja fragment mana yang mau ditampilkan dipaling depan

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }

}