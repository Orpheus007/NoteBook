package com.example.saberoueslati.notebook.db.note

import androidx.lifecycle.LiveData

interface NoteRepository {
    fun getAllNotes(): LiveData<List<Note>>
    suspend fun addNote(note: Note)
    suspend fun getNoteById(id: Int): LiveData<Note>
}