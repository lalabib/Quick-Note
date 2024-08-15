package com.project.quicknotes.domain.usecase

import com.project.quicknotes.data.local.entity.NoteEntities
import com.project.quicknotes.domain.repository.INoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteInteractor @Inject constructor(private val noteRepository: INoteRepository) :
    NoteUseCase {

    override fun getAllNotes(): Flow<List<NoteEntities>> = noteRepository.getAllNotes()

    override fun getNoteById(id: String): Flow<NoteEntities> = noteRepository.getNoteById(id)

    override suspend fun insertNote(noteEntities: NoteEntities) =
        noteRepository.insertNote(noteEntities)

    override suspend fun updateNote(noteEntities: NoteEntities) =
        noteRepository.updateNote(noteEntities)

    override suspend fun deleteNote(noteEntities: NoteEntities) =
        noteRepository.deleteNote(noteEntities)
}