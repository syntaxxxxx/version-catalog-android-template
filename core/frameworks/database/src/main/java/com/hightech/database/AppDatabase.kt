package com.hightech.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Class::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun yourDao(): BaseDao<Unit>
}