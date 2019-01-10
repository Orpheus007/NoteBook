package com.example.saberoueslati.notebook.concerns.notelist

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel

class AddNoteViewModel : ViewModel() {

    val titleTW: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //note.title = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

    val contentTW: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //note.content = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }
}