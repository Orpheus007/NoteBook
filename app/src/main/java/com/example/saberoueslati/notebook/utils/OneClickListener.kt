package com.example.saberoueslati.notebook.utils

import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

abstract class OneClickListener(var delay: Long) : View.OnClickListener {
    private var hasClicked: Boolean = true

    constructor() : this(1000)

    override fun onClick(it: View) {
        if (!hasClicked) {
            //stillWorking()
            return
        } else {
            hasClicked = false
            onClicked(it)
            GlobalScope.launch {
                delay(delay)
                hasClicked = true
            }
        }
    }


    //abstract fun stillWorking()
    abstract fun onClicked(it: View)
}