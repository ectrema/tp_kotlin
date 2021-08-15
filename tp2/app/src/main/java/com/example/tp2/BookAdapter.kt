package com.example.tp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bibliotheque.Book
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter(private val bookList: MutableList<Book>):RecyclerView.Adapter<BookViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.book_item, parent,false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.upddateWithBook(book)
    }

}

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun upddateWithBook(book: Book){
        val name = itemView.tv_name
        name?.text = book.name
        val author = itemView.tv_author
        author?.text = book.author
    }
}