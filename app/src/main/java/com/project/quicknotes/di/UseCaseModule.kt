package com.project.quicknotes.di

import com.project.quicknotes.data.repository.NoteRepository
import com.project.quicknotes.domain.usecase.NoteInteractor
import com.project.quicknotes.domain.usecase.NoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideNoteUseCase(noteRepository: NoteRepository): NoteUseCase =
        NoteInteractor(noteRepository)
}