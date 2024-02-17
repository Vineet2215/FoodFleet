package com.example.myfood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel

import com.example.myfood.R
import com.example.myfood.adapter.PopularAdapter
import com.example.myfood.databinding.ActivityLoginBinding
import com.example.myfood.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    // Activating binding
    private lateinit var binding: FragmentHomeBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner3, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList((imageList),ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener
        {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

        val foodName = listOf("Burger" , "Sandwich" , "Momo","Samosa")
        val price = listOf("$10" , "$15" , "$50","$10")
        val popularFoodImages = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)

        val adapter = PopularAdapter(foodName,price,popularFoodImages)
        binding.popularRV.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRV.adapter = adapter
    }
    companion object {

    }
}