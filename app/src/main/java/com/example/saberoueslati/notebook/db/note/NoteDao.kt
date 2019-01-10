package com.example.saberoueslati.notebook.db.note

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM Note WHERE nid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Note>

    @Insert
    fun insertAll(notes: List<Note>)

    @Insert
    fun insertNote(note: Note)

    @Query("SELECT * FROM Note WHERE nid = :id ")
    fun getNote(id: Int): LiveData<Note>

    @Delete
    fun delete(user: Note)

}