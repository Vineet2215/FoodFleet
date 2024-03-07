package com.example.myfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfood.adapter.MenuAdapter
import com.example.myfood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottomSheetFragment :BottomSheetDialogFragment(){

    // Binding
    private lateinit var binding :FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)


        binding.idBtnBack.setOnClickListener{
            dismiss()
        }

        // For Now Dummy Variable

        val menuFoodName = listOf("Burger" , "Sandwich" , "Momo","Samosa","Burger" , "Sandwich" , "Momo","Samosa")
        val menuItemPrice = listOf("$10" , "$15" , "$50","$10","$10" , "$15" , "$50","$10")
        val menuImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4 , R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)

        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImages))
        binding.idRVMenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.idRVMenuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}