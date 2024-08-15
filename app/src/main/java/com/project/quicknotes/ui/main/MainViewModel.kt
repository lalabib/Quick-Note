package com.project.quicknotes.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.project.quicknotes.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(noteUseCase: NoteUseCase): ViewModel() {

    val getAllNotes = noteUseCase.getAllNotes().asLiveData()
}