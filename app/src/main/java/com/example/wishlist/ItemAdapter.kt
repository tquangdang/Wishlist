package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.name)
        val priceTextView = itemView.findViewById<TextView>(R.id.price)
        val linkTextView = itemView.findViewById<TextView>(R.id.link)


    }

    // ... constructor and member variables
    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: ItemAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val item: Item = items.get(position)
        // Set item views based on your views and data model
        val nameTextView = viewHolder.nameTextView
        nameTextView.setText(item.name)

        val priceTextView = viewHolder.priceTextView
        priceTextView.setText(item.price.toString())

        val linkTextView = viewHolder.linkTextView
        linkTextView.setText(item.link)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return items.size
    }
}