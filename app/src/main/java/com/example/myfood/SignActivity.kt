package com.example.myfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfood.databinding.ActivitySignBinding
import com.example.myfood.databinding.ActivityStartBinding

class SignActivity : AppCompatActivity() {

    private val binding : ActivitySignBinding by lazy {
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.alreadyhvAcc.setOnClickListener{
            val intent = Intent(this , LoginActivity::class.java)
            startActivity((intent))
        }


    }
}