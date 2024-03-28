package com.fazztrack.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.databinding.FragmentNotificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment: BaseFragment<FragmentNotificationBinding>() {
    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }


}