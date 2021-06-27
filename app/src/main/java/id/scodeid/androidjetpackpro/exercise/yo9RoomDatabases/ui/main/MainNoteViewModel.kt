package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.Note
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.repository.NoteRepository

class MainNoteViewModel(application: Application) : ViewModel() {
    private val noteRepository: NoteRepository = NoteRepository(application)
    fun getAllNotes(): LiveData<PagedList<Note>> = LivePagedListBuilder(noteRepository.getAllNotes(), 12).build()
}