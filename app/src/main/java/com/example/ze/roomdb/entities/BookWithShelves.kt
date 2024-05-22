package com.example.ze.roomdb.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.ze.model.googlebooksmodel.DataModel

data class BookWithShelves(
    @Embedded val book: DataModel.LocalBook,
    @Relation(
        parentColumn = "bookId",
        entityColumn = "shelfId",
        associateBy = Junction(BookShelfCrossRef::class)
    )
    val shelfList: List<LocalShelf>
)