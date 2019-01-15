package com.example.saberoueslati.notebook.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.saberoueslati.notebook.application.di.module.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity() {
    override fun onPause() {
        super.onPause()
        Log.v("TAGG", "--- ON PAUSE ---")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("TAGG", "--- ON DESTROY ---")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("TAGG", "--- ON CREATE ---")

    }

    override fun onStart() {
        super.onStart()
        Log.v("TAGG", "--- ON START ---")

    }

    override fun onResume() {
        super.onResume()
        Log.v("TAGG", "--- ON RESUME ---")

    }

    override fun onStop() {
        super.onStop()
        Log.v("TAGG", "--- ON STOP ---")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("TAGG", "--- ON RESTART ---")

    }

    // TEST
    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProviders.of(this@BaseActivity, this)[T::class.java]
}