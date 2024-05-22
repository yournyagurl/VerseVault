package com.example.ze.repository

import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.roomdb.VVDao
import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.BookWithShelves
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalBooksRepositoryImpl @Inject constructor(
    private val VVDao: VVDao,
    private val coroutineContext: CoroutineDispatcher = Dispatchers.IO
) : LocalBooksRepositoryInterface {

    override suspend fun searchLocalBooks(searchString: String): List<DataModel.LocalBook> =
        withContext(coroutineContext) {
            VVDao.searchLocalBooks(searchString)
        }

    override suspend fun delete(localBook: DataModel.LocalBook) = withContext(coroutineContext) {
        VVDao.deleteBook(localBook)
    }

    override suspend fun deleteBookById(id: String) = withContext(coroutineContext) {
        VVDao.deleteBookById(id)
    }

    override suspend fun insert(localBook: DataModel.LocalBook) = withContext(coroutineContext) {
        VVDao.insertBook(localBook)
    }

    override suspend fun update(localBook: DataModel.LocalBook) = withContext(coroutineContext) {
        VVDao.updateBook(localBook)
    }

    override suspend fun getLocalBooks(): List<DataModel.LocalBook> =
        withContext(coroutineContext) {
            VVDao.getLocalBooks().sortedBy { it.bookTitle }
        }

    override suspend fun getBookWithShelves(bookId: String): List<BookWithShelves> =
        withContext(coroutineContext) {
            VVDao.getShelvesOfBook(bookId)
        }

    override suspend fun getBookShelfCrossRef(): List<BookShelfCrossRef> =
        withContext(coroutineContext) {
            VVDao.getBookShelfCrossRef()
        }

}