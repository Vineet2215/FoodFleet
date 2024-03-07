package com.example.myfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfood.R
import com.example.myfood.adapter.MenuAdapter
import com.example.myfood.databinding.FragmentSearchBinding



class SearchFragment : Fragment() {

    // Activating binding
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter

    private  val originalMenuFoodName = listOf("Burger" , "Sandwich" , "Momo","Samosa","Burger" , "Sandwich" , "Momo","Samosa","Burger" , "Sandwich" , "Momo","Samosa","Burger" , "Sandwich" , "Momo","Samosa")
    private val originalMenuItemPrice = listOf("$10" , "$15" , "$50","$10","$10" , "$15" , "$50","$10","$10" , "$15" , "$50","$10","$10" , "$15" , "$50","$10")
    private val originalMenuImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4 , R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4,R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4 , R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemsPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)


        adapter = MenuAdapter((filteredMenuFoodName),(filteredMenuItemsPrice),(filteredMenuImage))
        binding.idMenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.idMenuRecyclerView.adapter = adapter


        // Set Up For Search View
        setupSearchView()

        // Show All Menu
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu(){
        filteredMenuFoodName.clear()
        filteredMenuItemsPrice.clear()
        filteredMenuImage.clear()


        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemsPrice.addAll(originalMenuItemPrice)
        filteredMenuImage.addAll(originalMenuImages)

        adapter.notifyDataSetChanged()

    }
    private fun setupSearchView()
    {
        binding.idSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                filterMenuItems(query)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemsPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed{index, foodName ->
            if(foodName.contains(query,ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemsPrice.add(originalMenuItemPrice[index])
                filteredMenuImage.add(originalMenuImages[index])
            }
        }

        adapter.notifyDataSetChanged()
    }




    companion object {

    }
}

