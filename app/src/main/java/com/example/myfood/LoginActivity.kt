package com.example.myfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfood.databinding.ActivityLoginBinding
import com.example.myfood.databinding.ActivityStartBinding

class LoginActivity : AppCompatActivity() {

    private val binding : ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            val intent = Intent(this , SignActivity::class.java)
            startActivity((intent))
        }

        binding.notHvAcc.setOnClickListener{
            val intent = Intent(this , SignActivity::class.java)
            startActivity((intent))
        }
    }
}