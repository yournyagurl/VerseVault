package com.example.ze.roomdb.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.LocalShelf

data class ShelfWithBooks(
    @Embedded val shelf: LocalShelf,
    @Relation(
        parentColumn = "shelfId",
        entityColumn = "bookId",
        associateBy = Junction(BookShelfCrossRef::class)
    )
    val bookList: List<DataModel.LocalBook>
) {
    val booksCount: Int
        get() = bookList.size
}