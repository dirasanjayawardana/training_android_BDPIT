package com.fazztrack.bcasyariah.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.model.AccountBalanceModel
import com.fazztrack.bcasyariah.model.MenuDashboardModel
import com.fazztrack.bcasyariah.model.PromoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// tempat menyalurkan data dari useCase ke view

class DashboardViewModel : ViewModel() {

    // menggunakan _ menunjukkan variabel private
    //_homeMenu menampung semua logic dari MutableLiveData<>, bersifat private karena menampung semua logic, sebagai setter
    private val _homeMenu = MutableLiveData<List<MenuDashboardModel>>()

    // homeMenu hanya akan berisi return value dari logic MutableLiveData<>, sebagai getter
    val homeMenu: LiveData<List<MenuDashboardModel>> get() = _homeMenu

    // data dari homeMenu, sebagiknya disimpan dalam useCase
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

    // isi data homeMenu
    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO){
        _homeMenu.postValue(populateDataMenu())
    }

    //------------------------------------------------------------------------------------//
    // membuat setter accountBalance
    private val _accountBalance = MutableLiveData<List<AccountBalanceModel>>()

    // membuat getter accountBalance
    val accountBalance: LiveData<List<AccountBalanceModel>> get() = _accountBalance

    // data accountBalance, sebaiknya disimpan dalam useCase
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

    // isi data accountBalance
    fun getAccountBalance() = viewModelScope.launch(Dispatchers.IO){
        _accountBalance.postValue(populateDataBalance())
    }

    //------------------------------------------------------------------------------------//
    // membuat setter promo
    private val _promo = MutableLiveData<List<PromoModel>>()

    // membuat getter promo
    val promo: LiveData<List<PromoModel>> get() = _promo

    // data promo
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