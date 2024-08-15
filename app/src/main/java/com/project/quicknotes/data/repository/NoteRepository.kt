package com.project.quicknotes.data.repository

import com.project.quicknotes.data.local.LocalDataSource
import com.project.quicknotes.data.local.entity.NoteEntities
import com.project.quicknotes.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
) : INoteRepository {

    override fun getAllNotes(): Flow<List<NoteEntities>> = localDataSource.getAllNotes()

    override fun getNoteById(id: String): Flow<NoteEntities> = localDataSource.getNoteById(id)

    override suspend fun insertNote(noteEntities: NoteEntities) =
        localDataSource.insertNote(noteEntities)

    override suspend fun updateNote(noteEntities: NoteEntities) =
        localDataSource.updateNote(noteEntities)

    override suspend fun deleteNote(noteEntities: NoteEntities) =
        localDataSource.deleteNote(noteEntities)
}