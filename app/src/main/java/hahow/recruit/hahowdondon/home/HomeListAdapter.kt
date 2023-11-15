package hahow.recruit.hahowdondon.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hahow.recruit.hahowdondon.data.ClassInfo
import hahow.recruit.hahowdondon.databinding.ItemClassBinding

class HomeListAdapter: ListAdapter<ClassInfo, RecyclerView.ViewHolder>(ClassDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClassViewHolder(
            ItemClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val classInfo = getItem(position)
        when(holder){
            is ClassViewHolder -> holder.bind(classInfo)
            else -> throw IllegalArgumentException("HomeListAdapter onBindViewHolder holder unknown.")
        }
    }
}

class ClassViewHolder(private val binding: ItemClassBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(classInfo: ClassInfo) {

    }
}

private class ClassDiffCallback() : DiffUtil.ItemCallback<ClassInfo>() {
    override fun areItemsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean {
        return oldItem.coverImageUrl == newItem.coverImageUrl
    }

    override fun areContentsTheSame(oldItem: ClassInfo, newItem: ClassInfo): Boolean {
        return newItem == oldItem
    }
}