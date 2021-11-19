package com.kingof0.booksapp.network

import com.kingof0.booksapp.response.BookResponse
import retrofit2.Call
import retrofit2.http.GET

interface IBookDAO {

    @GET("all_books.php")
    fun getBooks() : Call<BookResponse>



}