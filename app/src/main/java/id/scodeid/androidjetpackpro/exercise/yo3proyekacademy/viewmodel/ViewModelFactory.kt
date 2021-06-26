package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.AcademyRepository
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.di.Injection
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.academy.AcademyViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.bookmark.BookmarkViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail.DetailCourseViewModel
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.CourseReaderViewModel

class ViewModelFactory private constructor(private val academyRepository: AcademyRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AcademyViewModel::class.java) -> {
                AcademyViewModel(academyRepository) as T
            }
            modelClass.isAssignableFrom(DetailCourseViewModel::class.java) -> {
                DetailCourseViewModel(academyRepository) as T
            }
            modelClass.isAssignableFrom(BookmarkViewModel::class.java) -> {
                BookmarkViewModel(academyRepository) as T
            }
            modelClass.isAssignableFrom(CourseReaderViewModel::class.java) -> {
                CourseReaderViewModel(academyRepository) as T
            }
            else -> throw Throwable("Unknow ViewModel class: " + modelClass.name)
        }
    }


}