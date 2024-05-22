package com.example.ze.repository

import com.example.ze.roomdb.VVDao
import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.LocalShelf
import com.example.ze.roomdb.entities.ShelfWithBooks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ShelfRepositoryImpl @Inject constructor(
    private val VVDao: VVDao,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : ShelfRepositoryInterface {
    override suspend fun insert(localShelf: LocalShelf) = withContext(coroutineContext) {
        VVDao.insertShelf(localShelf)
    }

    override suspend fun update(localShelf: LocalShelf) = withContext(coroutineContext) {
        VVDao.updateShelf(localShelf)
    }

    override suspend fun delete(localShelf: LocalShelf) = withContext(coroutineContext) {
        VVDao.deleteShelf(localShelf)
    }

    override suspend fun getLocalShelves(): List<LocalShelf> = withContext(coroutineContext) {
        VVDao.getLocalShelves().sortedByDescending {
            if (it.createdAt!!.length > 10) {
                it.createdAt
            } else {
                val inputFormat =
                    SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(it.createdAt!!)
                val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                outputFormat.format(inputFormat!!)
            }
        }
    }

    override suspend fun searchLocalShelves(searchString: String): List<LocalShelf> =
        withContext(coroutineContext) {
            VVDao.searchLocalShelf(searchString)
        }

    override suspend fun insertBookShelfCrossRef(crossRef: BookShelfCrossRef) =
        withContext(coroutineContext) {
            VVDao.insertBookShelfCrossRef(crossRef)
        }

    override suspend fun deleteBookShelfCrossRef(crossRef: BookShelfCrossRef) =
        withContext(coroutineContext) {
            VVDao.deleteBookShelfCrossRef(crossRef)
        }

    override suspend fun getShelfWithBooks(): List<ShelfWithBooks> = withContext(coroutineContext) {
        VVDao.getBooksOfShelf()
    }
}