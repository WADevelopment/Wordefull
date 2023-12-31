package com.gamovation.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gamovation.core.database.dao.LevelManagerDao
import com.gamovation.core.database.model.LevelData

@Database(
    version = 1,
    entities = [LevelData::class],
    exportSchema = false
)
abstract class WordefullDatabase : RoomDatabase() {
    abstract fun levelDataDao(): LevelManagerDao

    companion object {
        const val DATABASE_NAME = "tilecl.db"
    }
}
