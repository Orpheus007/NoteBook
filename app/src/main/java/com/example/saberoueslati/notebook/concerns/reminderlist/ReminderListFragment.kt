package com.example.saberoueslati.notebook.concerns.reminderlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.base.BaseFragment

class ReminderListFragment : BaseFragment() {
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