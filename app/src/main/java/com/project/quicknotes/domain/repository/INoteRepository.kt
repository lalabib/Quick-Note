package com.project.quicknotes.domain.repository

import com.project.quicknotes.data.local.entity.NoteEntities
import kotlinx.coroutines.flow.Flow

interface INoteRepository {
    fun getAllNotes(): Flow<List<NoteEntities>>

    fun getNoteById(id: String): Flow<NoteEntities>

    suspend fun insertNote(noteEntities: NoteEntities)

    suspend fun updateNote(noteEntities: NoteEntities)

    suspend fun deleteNote(noteEntities: NoteEntities)
}