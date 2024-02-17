package com.example.myfood.Fragment

import CartAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.myfood.R
import com.example.myfood.adapter.PopularAdapter
import com.example.myfood.databinding.FragmentCartBinding
import com.example.myfood.databinding.FragmentHomeBinding


class CartFragment : Fragment() {

    // Activating binding
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)


        val cartFoodName = listOf("Burger" , "Sandwich" , "Momo","Samosa","Burger" , "Sandwich" , "Momo","Samosa")
        val cartItemPrice = listOf("$10" , "$15" , "$50","$10","$10" , "$15" , "$50","$10")
        val cartImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4 , R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)

        val adapter = CartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImages))
        binding.idRVCart.layoutManager = LinearLayoutManager(requireContext())
        binding.idRVCart.adapter = adapter




        return binding.root
    }


    companion object {
    }
}