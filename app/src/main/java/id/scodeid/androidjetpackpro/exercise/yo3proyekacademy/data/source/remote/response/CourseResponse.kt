package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.remote.response
import android.os.Parcelable

data class CourseResponse(
    var id: String,
    var title: String,
    var description: String,
    var date: String,
    var imagePath: String
): Parcelable