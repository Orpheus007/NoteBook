package com.example.saberoueslati.notebook.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity() {
    override fun onPause() {
        super.onPause()
        Log.d("TAGG", "--- ON PAUSE ---")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAGG", "--- ON DESTROY ---")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAGG", "--- ON CREATE ---")

    }

    override fun onStart() {
        super.onStart()
        Log.d("TAGG", "--- ON START ---")

    }

    override fun onResume() {
        super.onResume()
        Log.d("TAGG", "--- ON RESUME ---")

    }

    override fun onStop() {
        super.onStop()
        Log.d("TAGG", "--- ON STOP ---")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAGG", "--- ON RESTART ---")

    }
}