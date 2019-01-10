package com.example.saberoueslati.notebook.concerns.reminderlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.saberoueslati.notebook.R

class ReminderListFragment : Fragment() {
    companion object {
        fun newInstance(): ReminderListFragment {
            val fragment = ReminderListFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.reminders_list_fragment, container, false)



        return view
    }
}