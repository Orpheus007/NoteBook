package com.example.saberoueslati.notebook.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {

    @Provides
    fun providesApplicationContext(): Application {
        return app
    }

}