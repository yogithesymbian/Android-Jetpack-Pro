package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.Note
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.repository.NoteRepository

class MainNoteViewModel(application: Application) : ViewModel() {
    private val noteRepository: NoteRepository = NoteRepository(application)
    fun getAllNotes(): LiveData<List<Note>> = noteRepository.getAllNotes()
}