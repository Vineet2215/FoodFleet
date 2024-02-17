package com.example.myfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.myfood.databinding.ActivityChooseLocationBinding

class ChooseLocation : AppCompatActivity() {

    // Binding Enable
    private val binding : ActivityChooseLocationBinding by lazy{
        ActivityChooseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val locationList :Array<String> = arrayOf("Jaipur" , "Odisha" , "Bundi" , " Sikar")
        val adopter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.expandable_list_content,locationList)
        val autoCompleteTextView : AutoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adopter)
    }
}