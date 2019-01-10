package com.example.saberoueslati.notebook

import android.app.Application
import androidx.annotation.UiThread
import com.example.saberoueslati.notebook.di.component.AppComponent
import com.example.saberoueslati.notebook.di.component.DaggerAppComponent
import com.example.saberoueslati.notebook.di.module.AppModule

class NoteBookApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        getApplicationComponent().inject(this)
        super.onCreate()
    }

    @UiThread
    fun getApplicationComponent(): AppComponent {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        return appComponent
    }
}