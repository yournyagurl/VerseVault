package com.example.ze.roomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ze.ui.shelves.ShelvesViewModel


@Entity(tableName = "Shelf")
data class LocalShelf(
    @PrimaryKey(autoGenerate = false) var shelfId: String,
    var shelfTitle: String?,
    var createdAt: String?,
    var shelfCover: String?,
) {
    constructor() : this("", "", "", "")

    fun getBookCount(shelvesViewModel: ShelvesViewModel): Int {
        return shelvesViewModel.shelfWithBooksList.value?.firstOrNull {
            it.shelf.shelfId == shelfId
        }?.booksCount ?: 0
    }
}