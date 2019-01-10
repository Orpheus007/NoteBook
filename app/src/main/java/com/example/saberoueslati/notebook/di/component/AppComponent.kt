package com.example.saberoueslati.notebook.di.component

import com.example.saberoueslati.notebook.NoteBookApplication
import com.example.saberoueslati.notebook.di.module.AppModule
import com.example.saberoueslati.notebook.di.scope.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(noteBookApplication: NoteBookApplication)
}