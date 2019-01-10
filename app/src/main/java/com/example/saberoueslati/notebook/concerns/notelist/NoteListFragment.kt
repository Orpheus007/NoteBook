package com.example.saberoueslati.notebook.concerns.notelist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.base.BaseFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteListFragment : BaseFragment() {

    companion object {
        fun newInstance(): NoteListFragment {
            val fragment = NoteListFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.note_list_fragment, container, false)

        val addNote = view.findViewById<FloatingActionButton>(R.id.addNote)
        addNote.setOnClickListener {
            val intent = Intent(activity!!, AddNoteActivity::class.java)
            startActivity(intent)
        }


        return view
    }
}