package com.example.ze.repository

import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.BookWithShelves


interface LocalBooksRepositoryInterface {

    suspend fun delete(localBook: DataModel.LocalBook)

    suspend fun deleteBookById(id: String)

    suspend fun insert(localBook: DataModel.LocalBook)

    suspend fun update(localBook: DataModel.LocalBook)

    suspend fun getLocalBooks(): List<DataModel.LocalBook>

    suspend fun searchLocalBooks(searchString: String): List<DataModel.LocalBook>

    suspend fun getBookWithShelves(bookId: String): List<BookWithShelves>

    suspend fun getBookShelfCrossRef(): List<BookShelfCrossRef>

}