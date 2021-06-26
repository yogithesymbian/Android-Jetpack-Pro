package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.reader.content

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.scodeid.androidjetpackpro.databinding.ItemsModuleListBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.local.entity.ModuleEntity

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) :
    RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {
    private val listModuleEntities = ArrayList<ModuleEntity>()

    internal fun setModules(moduleEntity: List<ModuleEntity>?) {
        if (moduleEntity == null) return
        this.listModuleEntities.clear()
        this.listModuleEntities.addAll(moduleEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModuleListAdapter.ModuleViewHolder {
        val binding =
            ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ModuleViewHolder, position: Int) {
        val module = listModuleEntities[position]
        viewHolder.bind(module)
        viewHolder.itemView.setOnClickListener {
            listener.onItemClicked(
                viewHolder.adapterPosition,
                listModuleEntities[viewHolder.adapterPosition].moduleId
            )
        }
    }

    override fun getItemCount(): Int = listModuleEntities.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }
}

internal interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}
