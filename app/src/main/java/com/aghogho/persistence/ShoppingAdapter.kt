package com.aghogho.persistence

import androidx.recyclerview.widget.RecyclerView
import com.aghogho.persistence.databinding.ShoppingItemBinding

class ShoppingAdapter(val shoppingItems: List<ShoppingModel>)
    :RecyclerView.Adapter<ShoppingAdapter.viewHolder>() {

    class ViewHolder(binding: ShoppingItemBinding):RecyclerView.ViewHolder(binding.root)
}