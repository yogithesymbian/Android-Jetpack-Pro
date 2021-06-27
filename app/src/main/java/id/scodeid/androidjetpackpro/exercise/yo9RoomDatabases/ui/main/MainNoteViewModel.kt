package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.Note
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.repository.NoteRepository

class MainNoteViewModel(application: Application) : ViewModel() {
    private val noteRepository: NoteRepository = NoteRepository(application)
    fun getAllNotes(sort: String): LiveData<PagedList<Note>> {
        return LivePagedListBuilder(noteRepository.getAllNotes(sort), 20).build()
    }
}