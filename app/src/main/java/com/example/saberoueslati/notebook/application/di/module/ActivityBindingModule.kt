package com.example.saberoueslati.notebook.application.di.module

import com.example.saberoueslati.notebook.addnote.AddNoteActivity
import com.example.saberoueslati.notebook.addnote.di.AddNoteModule
import com.example.saberoueslati.notebook.di.scope.ActivityScope
import com.example.saberoueslati.notebook.di.scope.FragmentScope
import com.example.saberoueslati.notebook.notelist.NoteListFragment
import com.example.saberoueslati.notebook.notelist.NoteListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [AddNoteModule::class])
    abstract fun bindAddNoteModule(): AddNoteActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [NoteListModule::class])
    abstract fun bindNoteListModule(): NoteListFragment

}