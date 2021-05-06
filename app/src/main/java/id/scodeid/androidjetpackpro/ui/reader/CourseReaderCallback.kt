package id.scodeid.androidjetpackpro.ui.reader

interface CourseReaderCallback {
    fun moveTo(position: Int, moduleId: String)
}