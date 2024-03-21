package com.fazztrack.bcasyariah.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.ActivityLoginBinding
import com.fazztrack.bcasyariah.utils.SharePrefHelper
import java.util.UUID

class LoginActivity : AppCompatActivity() {

    // membuat view binding,untuk menggantikan findViewById
    private lateinit var binding: ActivityLoginBinding

    // panggil objek sharepref untuk mengakses localStorage
    private lateinit var sharePref: SharePrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // memanggil layout yang sudah dibuat di resource
        setContentView(R.layout.activity_login)

        // inisialisasi sharePref agar bisa digunakan
        sharePref = SharePrefHelper(this)
        checkToken()
        changeStatusBarColor()

        // cara get element by id dengan cara binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRegister.setOnClickListener{
            handleRegister()
        }

        binding.tvShowFragment.setOnClickListener{
            handleShowFragment()
        }

        binding.tvListTransaction.setOnClickListener{
            handleShowListTransaction()
        }

        binding.btnLogin.setOnClickListener{
            if(binding.etUsernameLogin.text.isEmpty().not() && binding.etPasswordLogin.text.isEmpty().not()){
                val token = UUID.randomUUID().toString()
                sharePref.saveToken(token)
                handleLogin()
            } else {
                Toast.makeText(this, "Missing field!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvRegister.setOnClickListener {
            handleRegister()
        }

        binding.checkPassword.setOnClickListener{
            val showPassword = binding.checkPassword
            if (showPassword.isChecked) {
                binding.etPasswordLogin.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.etPasswordLogin.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

    }

    // check token
    private fun checkToken(){
        val getToken = sharePref.getToken()
        if(getToken.isNotEmpty()){
            handleLogin()
        }
    }

    // register
    private fun handleRegister(){
        // mengarahkan pindah halaman
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    // register
    private fun handleLogin(){
        // mengarahkan pindah halaman
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    // show fragment
    private fun handleShowFragment(){
        // mengarahkan pindah halaman
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    // show fragment
    private fun handleShowListTransaction(){
        // mengarahkan pindah halaman
        val intent = Intent(this, ListTransactionActivity::class.java)
        startActivity(intent)
    }

    // membuat function private (hanya bisa diakses di class yang sama)
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun changeStatusBarColor() {
        // Check if the Android version is Lollipop or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Set the status bar color to your desired color
            window.statusBarColor = resources.getColor(R.color.statusBar, theme)
        }
    }
}