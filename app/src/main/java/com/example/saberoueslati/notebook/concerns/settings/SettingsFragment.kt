package com.example.saberoueslati.notebook.concerns.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.base.BaseFragment

class SettingsFragment : BaseFragment() {
    companion object {
        fun newInstance(): SettingsFragment {
            val fragment = SettingsFragment()
            fragment.retainInstance = true
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.settings_fragment, container, false)



        return view
    }
}