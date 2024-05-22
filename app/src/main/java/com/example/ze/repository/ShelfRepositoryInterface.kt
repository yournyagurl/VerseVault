package com.example.ze.repository

import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.LocalShelf
import com.example.ze.roomdb.entities.ShelfWithBooks


interface ShelfRepositoryInterface {

    suspend fun insert(localShelf: LocalShelf)

    suspend fun update(localShelf: LocalShelf)

    suspend fun delete(localShelf: LocalShelf)

    suspend fun getLocalShelves(): List<LocalShelf>

    suspend fun searchLocalShelves(searchString: String): List<LocalShelf>

    suspend fun insertBookShelfCrossRef(crossRef: BookShelfCrossRef)

    suspend fun deleteBookShelfCrossRef(crossRef: BookShelfCrossRef)

    suspend fun getShelfWithBooks(): List<ShelfWithBooks>

}