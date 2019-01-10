package com.example.saberoueslati.notebook.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.saberoueslati.notebook.db.note.Note
import com.example.saberoueslati.notebook.db.note.NoteDao

@Database(
        entities = [Note::class],
        version = 1
)
abstract class NoteBookDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao


    companion object {
        @Volatile
        private var instance: NoteBookDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        NoteBookDatabase::class.java, "note_book.db")
                        .build()
    }
}