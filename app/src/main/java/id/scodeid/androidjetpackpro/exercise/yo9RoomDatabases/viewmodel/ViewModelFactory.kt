package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.insert.NoteAddUpdateViewModel
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.main.MainNoteViewModel

class ViewModelFactory private constructor(private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainNoteViewModel::class.java) -> {
                MainNoteViewModel(application) as T
            }
            modelClass.isAssignableFrom(NoteAddUpdateViewModel::class.java) -> {
                NoteAddUpdateViewModel(application) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}