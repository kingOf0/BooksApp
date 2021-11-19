package com.kingof0.booksapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.kingof0.booksapp.databinding.FragmentHomepageBinding
import com.kingof0.booksapp.model.Book
import com.kingof0.booksapp.network.ApiUtils
import com.kingof0.booksapp.response.BookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding

    var bookList = arrayListOf<Book>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(layoutInflater)

        getBookList()
        return binding.root
    }

    private fun getBookList() {
        ApiUtils.getBookDAO().getBooks().enqueue(
            object : Callback<BookResponse> {
                override fun onResponse(
                    call: Call<BookResponse>,
                    response: Response<BookResponse>
                ) {
                    response.body()?.books?.let {
                        bookList = it as ArrayList<Book>
                    }

                    val adapter = BookAdapter(bookList)
                    val recyclerView = binding.bookrRecyclerView
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = GridLayoutManager(context, 2)
                    recyclerView.setHasFixedSize(true)
                }

                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }
}