package com.example.myfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfood.databinding.FragmentHomeBinding
import com.example.myfood.databinding.PopularItemBinding

class PopularAdapter(private val items : List<String> ,private val price :List<String>,private val image:List<Int>): RecyclerView.Adapter<PopularAdapter.PopularViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val price = price[position]
        val image = image[position]
        holder.bind(item,image,price);

    }

    override fun getItemCount(): Int {
        return items.size
    }


    class PopularViewHolder(private  val binding: PopularItemBinding) :RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.idImgFoodItems
        fun bind(item: String, image: Int, price:String)
        {
            binding.idTVFoodName.text = item
            binding.idTVPrice.text = price
            imagesView.setImageResource(image)
        }

    }
}