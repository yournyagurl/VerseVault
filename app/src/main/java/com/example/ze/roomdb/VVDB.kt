package com.example.ze.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ze.model.googlebooksmodel.DataModel
import com.example.ze.roomdb.entities.BookShelfCrossRef
import com.example.ze.roomdb.entities.LocalShelf

@Database(
    entities = [
        DataModel.LocalBook::class,
        LocalShelf::class,
        BookShelfCrossRef::class
    ], version = 1, exportSchema = true
)
@TypeConverters(DataConverter::class)
abstract class VVDB : RoomDatabase() {
    abstract fun VVDao(): VVDao
}