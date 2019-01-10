package com.example.saberoueslati.notebook.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.saberoueslati.notebook.db.NoteBookDatabase
import com.example.saberoueslati.notebook.db.note.NoteRepository
import com.example.saberoueslati.notebook.db.note.NoteRepositoryImpl
import com.example.saberoueslati.notebook.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext app: Application): NoteBookDatabase {
        return Room.databaseBuilder(app, NoteBookDatabase::class.java, "note_book.db").build()
    }

    @Singleton
    @Provides
    fun provideRepository(noteDatabase: NoteBookDatabase): NoteRepository = NoteRepositoryImpl(noteDatabase)
}