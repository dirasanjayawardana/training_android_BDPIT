package com.fazztrack.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.adapter.MessageTabAdapter
import com.fazztrack.bcasyariah.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment: BaseFragment<FragmentMessageBinding>(){

    private var adapterMessage : MessageTabAdapter? = null

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupTabView()
    }

    private fun setupTabView(){
        val tabLayout = binding.tabMessage
        val viewPager = binding.viewPagerMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addListFragment(NotificationFragment())
        adapterMessage?.addListFragment(HistoryFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout, viewPager) { tab, possition ->
            when(possition){
                0 -> {
                    tab.text = "Notification"
                }
                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }

}