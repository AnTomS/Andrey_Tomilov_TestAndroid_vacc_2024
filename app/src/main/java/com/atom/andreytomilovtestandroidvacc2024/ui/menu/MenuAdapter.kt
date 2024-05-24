package com.atom.andreytomilovtestandroidvacc2024.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.atom.andreytomilovtestandroidvacc2024.R
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee

class MenuAdapter(private val onItemClicked: (Coffee) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.CoffeeViewHolder>() {

    private var items: List<Coffee> = listOf()

    fun setItems(items: List<Coffee>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_for_menu, parent, false)
        return CoffeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class CoffeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Coffee) {
            itemView.findViewById<TextView>(R.id.coffee_name).text = item.name
            itemView.findViewById<TextView>(R.id.coffee_price).text = item.price.toString()
            // Set image using your preferred image loading library, e.g., Glide
            itemView.setOnClickListener { onItemClicked(item) }
        }
    }
}