package com.example.project_02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val wishlist = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.wishlist)
        val nameInput = findViewById<EditText>(R.id.etName)
        val priceInput = findViewById<EditText>(R.id.etPrice)
        val urlInput = findViewById<EditText>(R.id.etUrl)
        val submitButton = findViewById<Button>(R.id.btnSubmit)

        val adapter = WishlistAdapter(wishlist)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val price = priceInput.text.toString()
            val url = urlInput.text.toString()

            if (name.isNotBlank() && price.isNotBlank() && url.isNotBlank()) {
                wishlist.add(WishlistItem(name, price, url))

                adapter.notifyItemInserted(wishlist.size - 1)

                nameInput.text.clear()
                priceInput.text.clear()
                urlInput.text.clear()
            }
        }
    }
}