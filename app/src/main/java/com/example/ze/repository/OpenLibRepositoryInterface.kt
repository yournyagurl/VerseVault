package com.example.ze.repository

import com.example.ze.constants.Response
import com.example.ze.model.openlibrarymodel.BookDetailsResponse
import com.example.ze.model.openlibrarymodel.OpenLibraryResponse
import kotlinx.coroutines.flow.Flow

interface OpenLibRepositoryInterface {

    fun getBooksByCategory(
        category: String,
        offset: Int
    ): Flow<Response<OpenLibraryResponse>>

    fun getBookKeyDetails(bookKey: String): Flow<Response<BookDetailsResponse.BookKeyResponse>>

    fun getBookLendingDetails(bookLendingKey: String): Flow<Response<BookDetailsResponse.BookLendingKeyResponse>>

    fun getRandomBookCoverForCategory(category: String): Flow<Response<String>>

}