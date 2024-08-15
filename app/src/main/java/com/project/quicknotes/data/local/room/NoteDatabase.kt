package com.project.quicknotes.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.quicknotes.data.local.entity.NoteEntities

@Database(
    entities = [NoteEntities::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}