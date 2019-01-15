package com.example.saberoueslati.notebook.notelist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.addnote.AddNoteActivity
import com.example.saberoueslati.notebook.application.di.module.ViewModelFactory
import com.example.saberoueslati.notebook.base.BaseFragment
import com.example.saberoueslati.notebook.databinding.NoteListBinding
import com.example.saberoueslati.notebook.db.note.Note
import com.example.saberoueslati.notebook.utils.OneClickListener
import javax.inject.Inject

class NoteListFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<NoteListViewModel>

    @Inject
    lateinit var adapter: NoteAdapter

    lateinit var viewModel: NoteListViewModel

    private lateinit var binding: NoteListBinding


    companion object {
        fun newInstance(): NoteListFragment {
            val fragment = NoteListFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelFactory.get()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.note_list_fragment, container, false)
        binding = NoteListBinding.bind(view)

        viewModel.getAllNotes()

        binding.recList.layoutManager = LinearLayoutManager(activity)

        binding.recList.adapter = adapter

        binding.addNote.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {
                val intent = Intent(activity!!, AddNoteActivity::class.java)
                startActivity(intent)
            }
        })
        viewModel.notes.observe(this, Observer { it -> adapter.setNotes(it.asReversed()) })

        return view
    }
}