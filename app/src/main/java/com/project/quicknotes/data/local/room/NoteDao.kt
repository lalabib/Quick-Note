package com.project.quicknotes.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.project.quicknotes.data.local.entity.NoteEntities
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("Select * from tb_note")
    fun getAllNotes(): Flow<List<NoteEntities>>

    @Query("Select * from tb_note where id = :id")
    fun getNoteById(id: String): Flow<NoteEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntities)

    @Update
    suspend fun updateNote(note: NoteEntities)

    @Delete
    suspend fun deleteNote(note: NoteEntities)
}