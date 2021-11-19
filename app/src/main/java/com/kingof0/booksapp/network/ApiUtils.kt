package com.kingof0.booksapp.network

class ApiUtils {

    companion object {

        private const val BASE_URL = "http://10.36.104.82/"

        fun getBookDAO() : IBookDAO {
            return RetrofitClient
                .getClient(BASE_URL)
                .create(IBookDAO::class.java)
        }

    }

}