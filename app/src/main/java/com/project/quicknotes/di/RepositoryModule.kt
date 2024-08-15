package com.project.quicknotes.di

import com.project.quicknotes.data.repository.NoteRepository
import com.project.quicknotes.domain.repository.INoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(noteRepository: NoteRepository): INoteRepository
}