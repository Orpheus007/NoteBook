package com.example.saberoueslati.notebook.notelist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.base.BaseActivity
import com.example.saberoueslati.notebook.databinding.AddNoteScreenBinding
import com.example.saberoueslati.notebook.utils.EventObserver
import com.example.saberoueslati.notebook.utils.OneClickListener
import es.dmoral.toasty.Toasty
import javax.inject.Inject

class AddNoteActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: AddNoteViewModel
    private lateinit var binding: AddNoteScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.add_note_activity)

        viewModel = ViewModelProviders.of(this, viewModelFactory)[AddNoteViewModel::class.java]
        binding.viewModel = viewModel

        binding.done.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {
                viewModel.saveNoteToDataBase()
                viewModel.logAllNotes()
            }
        })

        binding.goBack.setOnClickListener(object : OneClickListener() {
            override fun onClicked(it: View) {
                onBackPressed()
            }
        })

        viewModel.callBack.observe(this, EventObserver {
            Toasty.success(this, "Note Added Successfully", Toast.LENGTH_SHORT, true).show()
            onBackPressed()
        })
    }
}
