package com.example.saberoueslati.notebook.addnote.di

import androidx.lifecycle.MutableLiveData
import com.example.saberoueslati.notebook.db.note.Note
import com.example.saberoueslati.notebook.di.scope.ActivityScope
import com.example.saberoueslati.notebook.utils.Event
import com.example.saberoueslati.notebook.utils.ToolBoxImpl
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

@Module
class AddNoteModule {

    @ActivityScope
    @Provides
    fun provideNote(): Note {
        return Note()
    }

    @ActivityScope
    @Provides
    fun provideCallBack(): MutableLiveData<Event<Boolean>> {
        return MutableLiveData()
    }

    @ActivityScope
    @Provides
    fun provideJob(): Job {
        return Job()
    }

    @ActivityScope
    @Provides
    fun provideCoRoutineContext(job: Job): CoroutineContext {
        return job + Dispatchers.Main
    }

    @ActivityScope
    @Provides
    fun provideScope(coroutineContext: CoroutineContext): CoroutineScope {
        return CoroutineScope(coroutineContext)
    }

    @ActivityScope
    @Provides
    fun provideToolBox(): ToolBoxImpl {
        return ToolBoxImpl()
    }
}