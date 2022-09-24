package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameInput = findViewById<EditText>(R.id.inputName)
        var priceInput = findViewById<EditText>(R.id.inputPrice)
        var linkInput = findViewById<EditText>(R.id.inputLink)
        var tempItem : Item
        val button = findViewById<Button>(R.id.button)

        // Lookup the recyclerview in activity layout
        val rvItems = findViewById<RecyclerView>(R.id.recyclerView)
        // Initialize contacts todo
        val items =  ArrayList<Item>()
        // Create adapter passing in the sample user data
        val adapter = ItemAdapter(items)
        // Attach the adapter to the recyclerview to populate items
        rvItems.adapter = adapter
        // Set layout manager to position the items
        rvItems.layoutManager = LinearLayoutManager(this)
        // That's all!

        button.setOnClickListener {
            var inputName = nameInput.text.toString()
            var inputPrice = priceInput.text.toString()
            var inputLink = linkInput.text.toString()
            tempItem = Item(inputName, inputPrice, inputLink)
            items.add(tempItem)
            adapter.notifyDataSetChanged()
            nameInput.text.clear()
            priceInput.text.clear()
            linkInput.text.clear()
        }

    }
}