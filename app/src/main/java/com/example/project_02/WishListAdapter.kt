package com.example.project_02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(
    private val items: List<WishlistItem>
) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.nameText)
        val price: TextView = view.findViewById(R.id.priceText)
        val url: TextView = view.findViewById(R.id.urlText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wishlist, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.name.text = item.name
        holder.price.text = "$${item.price}"
        holder.url.text = item.url
    }

    override fun getItemCount(): Int {
        return items.size
    }
}