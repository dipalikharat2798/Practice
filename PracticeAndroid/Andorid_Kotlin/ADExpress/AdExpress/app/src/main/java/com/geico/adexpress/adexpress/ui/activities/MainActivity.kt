package com.geico.adexpress.adexpress.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geico.adexpress.adexpress.R
import com.geico.adexpress.adexpress.databinding.ActivityMainBinding
import com.geico.adexpress.adexpress.util.LoginUtils

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener {
            val username = binding.username.getText().toString()
            val password = binding.password.getText().toString()
            if (LoginUtils.validateRegistrationInput(username, password)) {
                Toast.makeText(
                    getApplicationContext(),
                    getString(R.string.redirecting_toast_msg),
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(
                    getApplicationContext(),
                    getString(R.string.wrong_credential_toast),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}