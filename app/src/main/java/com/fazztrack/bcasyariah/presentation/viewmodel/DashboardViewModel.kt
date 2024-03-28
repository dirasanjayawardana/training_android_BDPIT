package com.fazztrack.bcasyariah.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.data.remote.MenuDashboardRemoteDataSource
import com.fazztrack.bcasyariah.model.AccountBalanceModel
import com.fazztrack.bcasyariah.model.MenuDashboard
import com.fazztrack.bcasyariah.model.MenuDashboardModel
import com.fazztrack.bcasyariah.model.MenuDashboardResponse
import com.fazztrack.bcasyariah.model.PromoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// tempat menyalurkan data dari useCase ke view

@HiltViewModel
class DashboardViewModel @Inject constructor(private val menuDashboardRemoteDataSource: MenuDashboardRemoteDataSource) : ViewModel() {

    // menggunakan _ menunjukkan variabel private
    //_homeMenu menampung semua logic dari MutableLiveData<>, bersifat private karena menampung semua logic, sebagai setter
    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()

    // homeMenu hanya akan berisi return value dari logic MutableLiveData<>, sebagai getter
    val homeMenu: LiveData<MenuDashboardResponse> get() = _homeMenu

    // sebagai setter
    private val _homeMenuError = MutableLiveData<String>()
    // sebagai getter
    val homeMenuError: LiveData<String> get() = _homeMenuError

    // isi data homeMenu
    fun getHomeMenu( ) = viewModelScope.launch(Dispatchers.IO){
        menuDashboardRemoteDataSource.getMenuDashboard().let{
            if (it.isSuccessful) {
                _homeMenu.postValue(it.body())
            } else {
                _homeMenuError.postValue(it.message())
            }
        }
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