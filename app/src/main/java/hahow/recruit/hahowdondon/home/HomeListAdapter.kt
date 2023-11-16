package hahow.recruit.hahowdondon.home

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hahow.recruit.hahowdondon.R
import hahow.recruit.hahowdondon.data.ClassInfo
import hahow.recruit.hahowdondon.databinding.ItemClassBinding
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class HomeListAdapter(context: Context, private val click: (ClassInfo) -> Unit):
    ListAdapter<ClassInfo,
        RecyclerView.ViewHolder>
    (ClassDiffCallback()) {

    private val colorPrimary = ContextCompat.getColor(context, R.color.new_primary)
    private val colorTopic = ContextCompat.getColor(context, R.color.new_topic)
    private val colorTopic2 = ContextCompat.getColor(context, R.color.new_topic2)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClassViewHolder(
            ItemClassBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), colorPrimary, colorTopic, colorTopic2
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val classInfo = getItem(position)
        when(holder){
            is ClassViewHolder -> holder.bind(classInfo, click)
            else -> throw IllegalArgumentException("HomeListAdapter onBindViewHolder holder unknown.")
        }
    }
}

class ClassViewHolder(
    private val binding: ItemClassBinding,
    private val colorPrimary: Int,
    private val colorTopic: Int,
    private val colorTopic2: Int) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(classInfo: ClassInfo, click: (ClassInfo) -> Unit) {
        binding.classInfo = classInfo

        // status
        when(classInfo.status) {
            "INCUBATING" -> {
                binding.itemClassStatus.text =
                    binding.root.context.getString(R.string.statusIncubating)
                binding.itemClassStatus.backgroundTintList = ColorStateList.valueOf(colorTopic)
            }
            "SUCCESS" -> {
                binding.itemClassStatus.text =
                    binding.root.context.getString(R.string.statusSuccess)
                binding.itemClassStatus.backgroundTintList = ColorStateList.valueOf(colorTopic2)
            }
            "PUBLISHED" -> {
                binding.itemClassStatus.text =
                    binding.root.context.getString(R.string.statusPublished)
                binding.itemClassStatus.backgroundTintList = ColorStateList.valueOf(colorPrimary)
            }
            else -> binding.itemClassStatus.text =
                binding.root.context.getString(R.string.statusUnKnow)
        }

        // proposalDueTime
        if (classInfo.proposalDueTime == null) {
            binding.itemClassDueTime.visibility = View.GONE
        } else {
            binding.itemClassDueTime.visibility = View.VISIBLE
            daysFromReferenceDate(classInfo.proposalDueTime).also {
                binding.itemClassDueTime.text = binding.root.context.getString(R.string.proposalDueTime, it)
            }
        }

        // progress bar & percentage
        val rate: Double =
            classInfo.numSoldTickets.toDouble() / classInfo.successCriteria.numSoldTickets.toDouble()
        if (rate >= 1) {
            binding.itemClassProgressBar.progress = 100
            binding.itemClassSuccessCriteria.text =
                binding.root.context.getString(R.string.reachSuccessCriteria, (rate * 100).toInt())
            binding.itemClassProgressBar.progressTintList = ColorStateList.valueOf(colorPrimary)
        } else {
            binding.itemClassProgressBar.progress = (rate * 100).toInt()
            binding.itemClassSuccessCriteria.text =
                binding.root.context.getString(R.string.unReachSuccessCriteria,
                    classInfo.numSoldTickets, classInfo.successCriteria.numSoldTickets)
            binding.itemClassProgressBar.progressTintList = ColorStateList.valueOf(colorTopic)
        }

        // set dialog
        binding.itemHomeConstrain.setOnClickListener {
            click(classInfo)
        }
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

private fun daysFromReferenceDate(
    dateStr: String,
    referenceDateStr: String = "2021-12-01T16:00:00.000Z"
): String {
    val formatter = DateTimeFormatter.ISO_DATE_TIME
    val givenDate = ZonedDateTime.parse(dateStr, formatter)
    val referenceDate = ZonedDateTime.parse(referenceDateStr, formatter)

    return ChronoUnit.DAYS.between(referenceDate, givenDate).toString()
}
