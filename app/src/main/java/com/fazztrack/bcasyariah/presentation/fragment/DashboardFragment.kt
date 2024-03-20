package com.fazztrack.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.affan.bcas_app.base.BaseFragment
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.FragmentDashboardBinding
import com.fazztrack.bcasyariah.model.AccountBalanceModel
import com.fazztrack.bcasyariah.model.MenuDashboardModel
import com.fazztrack.bcasyariah.presentation.fragment.adapter.AccountBalanceAdapter
import com.fazztrack.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
import com.fazztrack.bcasyariah.utils.HorizontalItemDecoration

// fragment bisa ditampilkan di activity, satu activity bisa memiliki banyak fragment
// tinggal diatur saja fragment mana yang mau ditampilkan dipaling depan

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountBalanceAdapter: AccountBalanceAdapter

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
        setUpViewMenu()
        setUpViewAccountBalance()
    }

    private fun setUpViewMenu() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(),
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context,
                    populateDataMenu()[position].menuName,
                    Toast.LENGTH_SHORT
                ).show()
            }
    }

    private fun setUpViewAccountBalance() {
        accountBalanceAdapter = AccountBalanceAdapter(populateDataBalance())
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

    private fun populateDataMenu(): List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.menu1,
                menuName = "Transfer"
            ),
            MenuDashboardModel(
                image = R.drawable.menu2,
                menuName = "Pembelian"
            ),
            MenuDashboardModel(
                image = R.drawable.menu3,
                menuName = "Pembayaran"
            ),
            MenuDashboardModel(
                image = R.drawable.menu4,
                menuName = "Cardless"
            ),
            MenuDashboardModel(
                image = R.drawable.menu5,
                menuName = "History Transaksi"
            ),
            MenuDashboardModel(
                image = R.drawable.menu6,
                menuName = "Mutasi Rekening"
            ),
            MenuDashboardModel(
                image = R.drawable.menu7,
                menuName = "Jadwal Sholat"
            ),
        )
    }

    private fun populateDataBalance(): List<AccountBalanceModel> {
        return listOf(
            AccountBalanceModel(
                savingType = "Tahapan Wadiah",
                noRek = 232323445,
                balanceAmount = "Rp 1.000.000,00-"
            ),
            AccountBalanceModel(
                savingType = "Tahapan Wadiah",
                noRek = 232323445,
                balanceAmount = "Rp 1.000.000,00-"
            ),
            AccountBalanceModel(
                savingType = "Tahapan Wadiah",
                noRek = 232323445,
                balanceAmount = "Rp 1.000.000,00-"
            ),
        )
    }

}