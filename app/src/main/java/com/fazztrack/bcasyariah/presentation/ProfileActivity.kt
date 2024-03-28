package com.fazztrack.bcasyariah.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fazztrack.bcasyariah.presentation.RegisterActivity.Companion.KEY_NAME
import com.fazztrack.bcasyariah.databinding.ActivityProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity: AppCompatActivity() {

    // membuat view binding, untuk menggantikan findViewById
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // cara get element by id dengan cara binding
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getName = intent.getStringExtra(KEY_NAME)

        binding.textNameProfile.text = getName

        binding.layoutComponentTopbar.textTopbar.text = "Profile"
        binding.layoutComponentTopbar.imgBack.setOnClickListener{
            onBackPressed()
        }
    }
}