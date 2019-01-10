package com.example.saberoueslati.notebook.application.di.module

import android.content.Context
import com.example.saberoueslati.notebook.application.NoteBookApplication
import com.example.saberoueslati.notebook.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @ApplicationContext
    @Provides
    fun provideApplicationContext(app: NoteBookApplication): Context = app
}