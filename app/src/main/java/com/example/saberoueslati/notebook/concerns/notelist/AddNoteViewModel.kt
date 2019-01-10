package com.example.saberoueslati.notebook.concerns.notelist

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saberoueslati.notebook.db.note.Note
import com.example.saberoueslati.notebook.db.note.NoteRepositoryImpl
import com.example.saberoueslati.notebook.utils.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(private var note: Note,
                                           private val scope: CoroutineScope,
                                           private val repositoryImpl: NoteRepositoryImpl,
                                           val callBack: MutableLiveData<Event<Boolean>>) : ViewModel() {

    val titleTW: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                note.title = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

    val contentTW: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                note.content = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

    fun saveNoteToDataBase() = scope.launch {
        repositoryImpl.addNote(note)
        note = Note()
        callBack.value = Event(true)
    }

    fun logAllNotes() = scope.launch {
        Log.i(
                "Test", " => $note \n ${repositoryImpl.getAllNotes()}"
        )
    }

    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancel()
    }

}