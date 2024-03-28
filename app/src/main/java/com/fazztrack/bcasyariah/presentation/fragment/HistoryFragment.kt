package com.fazztrack.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.databinding.FragmentHistoryBinding
import com.fazztrack.bcasyariah.databinding.FragmentMessageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment: BaseFragment<FragmentHistoryBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }

}