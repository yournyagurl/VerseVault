package com.example.ze.constants

import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.model.openlibrarymodel.OpenLibraryWork
import com.example.ze.roomdb.entities.LocalShelf


object Cache {
    var currentGoogleBook: DataModel.GoogleBookItem? = null
    var currentLocalBook: DataModel.LocalBook? = null
    var currentOpenLibBook: OpenLibraryWork? = null
    var currentOpenLibBookCategory: List<String>? = null
    var currentShelf: LocalShelf? = null
    var currentBookIdExtra: String? = null
}