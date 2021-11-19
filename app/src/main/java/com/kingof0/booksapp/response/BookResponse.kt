package com.kingof0.booksapp.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.kingof0.booksapp.model.Book
import java.io.Serializable

data class BookResponse(
    @SerializedName("books")
    @Expose val books: List<Book>,

    @SerializedName("success")
    @Expose val success: Int
) : Serializable