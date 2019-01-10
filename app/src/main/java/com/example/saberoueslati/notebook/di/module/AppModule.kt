package com.example.saberoueslati.notebook.di.module

import android.app.Application
import com.example.saberoueslati.notebook.NoteBookApplication
import com.example.saberoueslati.notebook.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @ApplicationContext
    @Provides
    fun provideApplicationContext(app: NoteBookApplication): Application = app
}