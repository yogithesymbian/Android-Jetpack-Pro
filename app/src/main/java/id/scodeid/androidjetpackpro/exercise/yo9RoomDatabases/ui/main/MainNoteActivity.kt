package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.ActivityMainNoteBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail.DetailCourseViewModel
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database.Note
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.ui.insert.NoteAddUpdateActivity
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.utils.SortUtils
import id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.viewmodel.ViewModelFactory

class MainNoteActivity : AppCompatActivity() {

    private var _activityMainNoteBinding: ActivityMainNoteBinding? = null
    private val binding get() = _activityMainNoteBinding

    private lateinit var mainNoteViewModel: MainNoteViewModel
    private lateinit var adapter: NotePagedListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainNoteBinding = ActivityMainNoteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        mainNoteViewModel = obtainViewModel(this@MainNoteActivity)
        mainNoteViewModel.getAllNotes(SortUtils.NEWEST).observe(this, noteObserver)


        adapter = NotePagedListAdapter(this@MainNoteActivity)
        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter

        binding?.fabAdd?.setOnClickListener { view ->
            if (view.id == R.id.fab_add) {
                val intent = Intent(this@MainNoteActivity, NoteAddUpdateActivity::class.java)
                startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_ADD)
            }
        }

    }

    private fun obtainViewModel(activity: AppCompatActivity): MainNoteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[MainNoteViewModel::class.java]
    }

    private val noteObserver = Observer<PagedList<Note>> { noteList ->
        if (noteList != null) {
            adapter.submitList(noteList)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (requestCode == NoteAddUpdateActivity.REQUEST_ADD) {
                if (resultCode == NoteAddUpdateActivity.RESULT_ADD) {
                    showSnackbarMessage(getString(R.string.added))
                }
            } else if (requestCode == NoteAddUpdateActivity.REQUEST_UPDATE) {
                if (resultCode == NoteAddUpdateActivity.RESULT_UPDATE) {
                    showSnackbarMessage(getString(R.string.changed))
                } else if (resultCode == NoteAddUpdateActivity.RESULT_DELETE) {
                    showSnackbarMessage(getString(R.string.deleted))
                }
            }
        }
    }

    private fun showSnackbarMessage(message: String) {
        Snackbar.make(binding?.root as View, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.action_newest -> sort = SortUtils.NEWEST
            R.id.action_oldest -> sort = SortUtils.OLDEST
            R.id.action_random -> sort = SortUtils.RANDOM
        }
        mainNoteViewModel.getAllNotes(sort).observe(this, noteObserver)
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _activityMainNoteBinding = null
    }

}