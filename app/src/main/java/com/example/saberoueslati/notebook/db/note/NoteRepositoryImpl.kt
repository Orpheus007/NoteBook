package com.example.saberoueslati.notebook.db.note

import androidx.lifecycle.LiveData
import com.example.saberoueslati.notebook.db.NoteBookDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDatabase: NoteBookDatabase) : NoteRepository {
    override suspend fun getAllNotes(): List<Note> {
        return withContext(Dispatchers.IO) {
            noteDatabase.noteDao().getAll()
        }
    }

    override suspend fun addNote(note: Note) {
        return withContext(Dispatchers.IO) {
            noteDatabase.noteDao().insertNote(note)
        }
    }

    override suspend fun getNoteById(id: Int): LiveData<Note> {
        return withContext(Dispatchers.IO) {
            noteDatabase.noteDao().getNote(id)
        }
    }
}