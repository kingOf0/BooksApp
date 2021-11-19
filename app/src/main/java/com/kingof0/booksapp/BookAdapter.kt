package com.kingof0.booksapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kingof0.booksapp.databinding.BookCardBinding
import com.kingof0.booksapp.model.Book
import com.squareup.picasso.Picasso

class BookAdapter(private var bookList: ArrayList<Book>) :
    RecyclerView.Adapter<BookAdapter.BookCardDesign>() {

    class BookCardDesign(val binding: BookCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookCardDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = BookCardBinding.inflate(layoutInflater, parent, false)

        return BookCardDesign(binding)
    }

    override fun onBindViewHolder(holder: BookCardDesign, position: Int) {
        val book = bookList[position]

        holder.binding.apply {
            this.bookTitleText.text = book.name
            Picasso.get().load(book.url).into(this.bookImageView)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}