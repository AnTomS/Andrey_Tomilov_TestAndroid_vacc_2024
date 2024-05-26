package com.atom.andreytomilovtestandroidvacc2024.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atom.andreytomilovtestandroidvacc2024.databinding.ItemForMenuBinding
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.bumptech.glide.Glide

class MenuAdapter(private val onItemClicked: (Coffee) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.CoffeeViewHolder>() {

    private var items: List<Coffee> = listOf()

    fun setItems(items: List<Coffee>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemForMenuBinding.inflate(inflater, parent, false)
        return CoffeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CoffeeViewHolder(private val binding: ItemForMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coffee) {
            binding.apply {
                coffeeName.text = item.name
                coffeePrice.text = item.price.toString()
                Glide.with(binding.root)
                    .load(item.image)
                    .into(binding.coffeeImage)
                itemView.setOnClickListener { onItemClicked(item) }
            }
        }
    }
}