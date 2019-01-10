package com.example.saberoueslati.notebook.application.di.component

import com.example.saberoueslati.notebook.application.NoteBookApplication
import com.example.saberoueslati.notebook.application.di.module.ActivityBindingModule
import com.example.saberoueslati.notebook.application.di.module.AppModule
import com.example.saberoueslati.notebook.application.di.module.DatabaseModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBindingModule::class, DatabaseModule::class])
interface AppComponent : AndroidInjector<NoteBookApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<NoteBookApplication>()

}