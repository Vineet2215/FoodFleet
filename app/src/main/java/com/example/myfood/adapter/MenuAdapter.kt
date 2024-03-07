package com.example.myfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfood.databinding.CartItemBinding
import com.example.myfood.databinding.FragmentMenuBottomSheetBinding
import com.example.myfood.databinding.MenuItemBinding

class MenuAdapter(private val menuItems:MutableList<String>,private val menuItemPrice:MutableList<String>,private val menuImage:MutableList<Int>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        return MenuViewHolder(MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItems.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            binding.apply {
                idTVMenuFoodName.text = menuItems[position]
                idTVMenuPrice.text = menuItemPrice[position]
                idImgMenu.setImageResource(menuImage[position])
            }
        }
    }

}