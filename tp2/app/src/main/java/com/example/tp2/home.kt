package com.example.tp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliotheque.Book

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        Book("salut", "oui")
        val listBook: ArrayList<Book> = arrayListOf(
            Book("livre 1", "author 1 "),
            Book("livre 2", "author 2")
        )
        val recyclerView: RecyclerView = findViewById(R.id.recycle_view) as RecyclerView
        recyclerView.adapter = BookAdapter(listBook)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }
}