package com.fazztrack.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fazztrack.bcasyariah.R
import com.fazztrack.bcasyariah.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    // membuat view binding,untuk menggantikan findViewById
    private lateinit var binding: ActivityRegisterBinding

    private var isShowPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // cara get element by id dengan cara binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleRegister()

        binding.imgShowPassword.setOnClickListener{
            isShowPassword = !isShowPassword

            if(isShowPassword){
                binding.imgShowPassword.setImageResource((R.drawable.hide))
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            } else {
                binding.imgShowPassword.setImageResource((R.drawable.show))
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            }
        }

    }

    // register
    private fun handleRegister(){
        // val (nilainya tidak bisa diubah atau constant), var (nilainya bisa diubah)
        val etName = binding.etName
        val etAddress = binding.etAddress
        val etPassword = binding.etPassword
        val nameValue = etName.text
        val addressValue = etAddress.text
        val passwordValue = etPassword.text

        // menambahkan event listener ketika button diclick
        binding.btnRegister.setOnClickListener{
            if (nameValue.isEmpty() || passwordValue.isEmpty() || addressValue.isEmpty()){
                showToast("Harap lengkapi data!")
            } else {
                // mengarahkan pindah halaman
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra(KEY_NAME, nameValue.toString())
                startActivity(intent)
            }
        }

    }

    // membuat function private (hanya bisa diakses di class yang sama)
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // untuk memanggil variabel tanpa membuat object atau memanggil class
    companion object{
        const val KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"
    }
}