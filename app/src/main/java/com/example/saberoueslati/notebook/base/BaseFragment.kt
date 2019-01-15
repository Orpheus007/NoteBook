package com.example.saberoueslati.notebook.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.saberoueslati.notebook.application.di.module.ViewModelFactory
import dagger.android.support.DaggerFragment

open class BaseFragment : DaggerFragment() {
    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProviders.of(this@BaseFragment, this)[T::class.java]
}