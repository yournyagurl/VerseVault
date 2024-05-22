package com.example.ze.repository

import com.example.ze.R
import com.example.ze.constants.Response
import com.example.ze.constants.Util.Companion.toLocalizedString
import com.example.ze.model.googlebooksmodel.BookDetails
import com.example.ze.model.googlebooksmodel.GoogleApiBooks
import com.example.ze.service.GoogleBooksApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GoogleBooksRepositoryImpl @Inject constructor(
    private val googleBooksApiService: GoogleBooksApiService
) : GoogleBooksRepositoryInterface {

    override fun getBookDetails(bookId: String): Flow<Response<BookDetails>> =
        flow {
            emit(Response.Loading)
            val response = googleBooksApiService.getBookDetails(bookId)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let emit(Response.Success(it))
                }
                    ?: emit(Response.Failure(R.string.something_went_wrong.toLocalizedString()))
            } else {
                emit(Response.Failure(R.string.something_went_wrong.toLocalizedString()))
            }
        }.catch {
            emit(Response.Failure(R.string.error_with_message.toLocalizedString(it.localizedMessage)))
        }

    override fun searchBooksFromApi(searchQuery: String): Flow<Response<GoogleApiBooks>> =
        flow {
            emit(Response.Loading)
            val response = googleBooksApiService.searchBooks(searchQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let emit(Response.Success(it))
                }
                    ?: emit(Response.Failure(R.string.something_went_wrong.toLocalizedString()))
            } else {
                emit(Response.Failure(R.string.something_went_wrong.toLocalizedString()))
            }
        }.catch {
            emit(Response.Failure(R.string.error_with_message.toLocalizedString(it.localizedMessage)))
        }
}