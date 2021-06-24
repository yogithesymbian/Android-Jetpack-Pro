package id.scodeid.androidjetpackpro.exercise.yo9RoomDatabases.data.source.database

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "date")
    var date: String? = null
) : Parcelable