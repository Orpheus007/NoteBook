package com.example.saberoueslati.notebook.concerns.notelist

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.base.BaseActivity
import com.example.saberoueslati.notebook.databinding.AddNoteScreenBinding
import com.example.saberoueslati.notebook.utils.OneClickListener

class AddNoteActivity : BaseActivity() {

    private lateinit var binding: AddNoteScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_note_activity)

        binding.done.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {

            }
        })
    }
}
