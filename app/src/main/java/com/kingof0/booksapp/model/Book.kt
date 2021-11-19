package com.kingof0.booksapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Book(
    @SerializedName("book_id")
    @Expose val id: Int,

    @SerializedName("book_name")
    @Expose val name: String,

    @SerializedName("book_author")
    @Expose val author: String,

    @SerializedName("book_publisher")
    @Expose val publisher: String,

    @SerializedName("book_price")
    @Expose val price: String,

    @SerializedName("book_image_url")
    @Expose val url: String,
) : Serializable