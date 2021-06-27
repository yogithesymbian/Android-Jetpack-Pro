package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.Note
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.NoteDao
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.NoteRoomDatabase
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.utils.SortUtils
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val notesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        notesDao = db.noteDao()
    }

    fun getAllNotes(sort: String): DataSource.Factory<Int, Note> {
        val query = SortUtils.getSortedQuery(sort)
        return notesDao.getAllNotes(query)
    }

    fun insert(note: Note) {
        executorService.execute { notesDao.insert(note) }
    }

    fun delete(note: Note) {
        executorService.execute { notesDao.delete(note) }
    }

    fun update(note: Note) {
        executorService.execute { notesDao.update(note) }
    }
}