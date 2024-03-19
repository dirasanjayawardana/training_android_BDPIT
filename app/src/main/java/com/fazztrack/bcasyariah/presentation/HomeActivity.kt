package com.fazztrack.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.ActivityHomeBinding
import com.fazztrack.bcasyariah.presentation.fragment.AdminFragment
import com.fazztrack.bcasyariah.presentation.fragment.DashboardFragment
import com.fazztrack.bcasyariah.presentation.fragment.InboxFragment
import com.fazztrack.bcasyariah.presentation.fragment.MessageFragment
import com.fazztrack.bcasyariah.utils.ConfirmationDialogUtil
import com.fazztrack.bcasyariah.utils.SharePrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    // panggil objek sharepref untuk mengakses localStorage
    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navHome -> {
                replaceFragment(DashboardFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navAdmin -> {
                replaceFragment(AdminFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navInbox -> {
                replaceFragment(InboxFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navMessage -> {
                replaceFragment(MessageFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navLogout -> {
                showConfirmation()
                return@OnNavigationItemSelectedListener false
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // inisialisasi sharePref agar bisa digunakan
        sharePref = SharePrefHelper(this)

        confirmationDialogUtil = ConfirmationDialogUtil(this)

        binding.bottomNav.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if(savedInstanceState == null){
            binding.bottomNav.selectedItemId = R.id.navHome
        }
    }

    private fun showConfirmation(){
        val title = "Apakah anda ingin keluar?"
        val icon = R.drawable.logo

        confirmationDialogUtil.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            },
            onCancel = {

            }
        )
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}