package com.project.quicknotes.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.quicknotes.data.local.entity.NoteEntities
import com.project.quicknotes.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val noteUseCase: NoteUseCase) : ViewModel() {

    fun getNoteById(id: String) = noteUseCase.getNoteById(id).asLiveData()

    fun insertNote(note: NoteEntities) {
        viewModelScope.launch {
            noteUseCase.insertNote(note)
        }
    }

    fun updateNote(note: NoteEntities) {
        viewModelScope.launch {
            noteUseCase.updateNote(note)
        }
    }

    fun deleteNote(note: NoteEntities) {
        viewModelScope.launch {
            noteUseCase.deleteNote(note)
        }
    }
}