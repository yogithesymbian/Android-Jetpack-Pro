package id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.scodeid.androidjetpackpro.databinding.ItemsModuleListBinding
import id.scodeid.androidjetpackpro.exercise.yo3proyekacademy.data.source.ModuleEntity

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>(){
    private val listModules = ArrayList<ModuleEntity>()

    fun setModules(moduleEntity: List<ModuleEntity>?){
        if (moduleEntity == null ) return
        this.listModules.clear()
        this.listModules.addAll(moduleEntity)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val itemModuleListBinding = ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(viewHolder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        viewHolder.bind(module)
    }
    override fun getItemCount(): Int = listModules.size

    inner class ModuleViewHolder(private val binding: ItemsModuleListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }

}