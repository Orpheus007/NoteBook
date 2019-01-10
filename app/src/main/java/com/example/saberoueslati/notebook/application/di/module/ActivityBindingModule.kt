package com.example.saberoueslati.notebook.application.di.module

import com.example.saberoueslati.notebook.notelist.di.AddNoteModule
import com.example.saberoueslati.notebook.notelist.AddNoteActivity
import com.example.saberoueslati.notebook.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [AddNoteModule::class, ViewModelModule::class])
    abstract fun bindAddNoteModule(): AddNoteActivity

}