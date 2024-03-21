package com.fazztrack.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.FragmentDashboardBinding
import com.fazztrack.bcasyariah.model.AccountBalanceModel
import com.fazztrack.bcasyariah.model.MenuDashboardModel
import com.fazztrack.bcasyariah.model.PromoModel
import com.fazztrack.bcasyariah.presentation.fragment.adapter.AccountBalanceAdapter
import com.fazztrack.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
import com.fazztrack.bcasyariah.presentation.fragment.adapter.PromoAdapter
import com.fazztrack.bcasyariah.presentation.viewmodel.DashboardViewModel
import com.fazztrack.bcasyariah.utils.HorizontalItemDecoration

// fragment bisa ditampilkan di activity, satu activity bisa memiliki banyak fragment
// tinggal diatur saja fragment mana yang mau ditampilkan dipaling depan

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountBalanceAdapter: AccountBalanceAdapter
    private lateinit var promoAdapter: PromoAdapter

    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelOffset(R.dimen.spacing16),
            true
        )
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setUpViewPromo()

        viewModel.getHomeMenu()
        viewModel.getAccountBalance()
        observeViewModel()

    }

    private fun observeViewModel(){
        viewModel.homeMenu.observe(viewLifecycleOwner){data ->
            setUpViewMenu(data)
        }

        viewModel.accountBalance.observe(viewLifecycleOwner){data ->
            setUpViewAccountBalance(data)
        }
    }

    private fun setUpViewMenu(data: List<MenuDashboardModel>) {
        menuAdapter = DashboardMenuAdapter(
            menuData = data,
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context,
                    data[position].menuName,
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun setUpViewAccountBalance(data: List<AccountBalanceModel>) {
        accountBalanceAdapter = AccountBalanceAdapter(data)
        binding.componentBalance.rvAccountBalance.adapter = accountBalanceAdapter

        // untuk setting orientasi recycle viewnya, bisa juga secara manual edit orientation di component recycleView
        binding.componentBalance.rvAccountBalance.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )

        // menambahkan styling untuk setiap item recycleView
        binding.componentBalance.rvAccountBalance.apply {
            if(itemDecorationCount <=0){
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun setUpViewPromo() {
        promoAdapter = PromoAdapter(populateDataPromo())
        binding.componentPromo.rvPromo.adapter = promoAdapter

        // untuk setting orientasi recycle viewnya, bisa juga secara manual edit orientation di component recycleView
        binding.componentPromo.rvPromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )

        // menambahkan styling untuk setiap item recycleView
        binding.componentPromo.rvPromo.apply {
            if(itemDecorationCount <=0){
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun populateDataPromo(): List<PromoModel> {
        return listOf(
            PromoModel(
                image = R.drawable.promo1
            ),
            PromoModel(
                image = R.drawable.promo2
            ),
            PromoModel(
                image = R.drawable.promo3
            ),
            PromoModel(
                image = R.drawable.promo4
            ),
        )
    }

}