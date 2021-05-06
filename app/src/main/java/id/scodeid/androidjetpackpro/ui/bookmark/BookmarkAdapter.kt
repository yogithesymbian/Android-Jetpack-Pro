package id.scodeid.androidjetpackpro.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.scodeid.androidjetpackpro.R
import id.scodeid.androidjetpackpro.databinding.ItemsBookmarkBinding
import id.scodeid.androidjetpackpro.entity.CourseEntity
import id.scodeid.androidjetpackpro.ui.detail.DetailCourseActivity

class BookmarkAdapter(private val callback: BookmarkFragmentCallback) :
    RecyclerView.Adapter<BookmarkAdapter.CourseViewHolder>() {

    private val listCourses = ArrayList<CourseEntity>()

    fun setCourses(courses: List<CourseEntity>?) {
        if (courses == null) return
        this.listCourses.clear()
        this.listCourses.addAll(courses)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookmarkAdapter.CourseViewHolder {
        val itemsBookmarkBinding =
            ItemsBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(itemsBookmarkBinding)
    }

    override fun onBindViewHolder(holder: BookmarkAdapter.CourseViewHolder, position: Int) {
        val course = listCourses[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listCourses.size

    inner class CourseViewHolder(private val binding: ItemsBookmarkBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(courseEntity: CourseEntity) {
            with(binding) {
                tvItemTitle.text = courseEntity.title
                tvItemDate.text =
                    itemView.resources.getString(R.string.deadline_date, courseEntity.deadline)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, courseEntity.courseId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener {
                    callback.onShareClick(courseEntity)
                }
                Glide.with(itemView.context)
                    .load(courseEntity.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }

}