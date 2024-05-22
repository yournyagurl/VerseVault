package com.example.ze.repository

import com.example.ze.constants.Response
import com.example.ze.model.googlebooksmodel.BookDetails
import com.example.ze.model.googlebooksmodel.GoogleApiBooks
import kotlinx.coroutines.flow.Flow

interface GoogleBooksRepositoryInterface {

    fun getBookDetails(bookId: String): Flow<Response<BookDetails>>

    fun searchBooksFromApi(searchQuery: String): Flow<Response<GoogleApiBooks>>

}