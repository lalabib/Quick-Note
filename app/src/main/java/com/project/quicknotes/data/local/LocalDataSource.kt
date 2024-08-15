package com.project.quicknotes.data.local

import com.project.quicknotes.data.local.entity.NoteEntities
import com.project.quicknotes.data.local.room.NoteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val noteDao: NoteDao){

    fun getAllNotes(): Flow<List<NoteEntities>> = noteDao.getAllNotes()

    fun getNoteById(id: String): Flow<NoteEntities> = noteDao.getNoteById(id)

    suspend fun insertNote(noteEntities: NoteEntities) = noteDao.insertNote(noteEntities)

    suspend fun updateNote(noteEntities: NoteEntities) = noteDao.updateNote(noteEntities)

    suspend fun deleteNote(noteEntities: NoteEntities) = noteDao.deleteNote(noteEntities)
}