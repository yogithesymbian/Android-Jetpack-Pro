package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.Note
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.repository.NoteRepository

class NoteAddUpdateViewModel(application: Application) : ViewModel() {
    private val noteRepository: NoteRepository = NoteRepository(application)
    fun insert(note: Note) {
        noteRepository.insert(note)
    }

    fun update(note: Note) {
        noteRepository.update(note)
    }

    fun delete(note: Note) {
        noteRepository.delete(note)
    }
}