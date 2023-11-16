package hahow.recruit.hahowdondon.home

import android.content.Context
import android.view.LayoutInflater
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hahow.recruit.hahowdondon.data.ClassInfo
import hahow.recruit.hahowdondon.data.ClassListInfo
import hahow.recruit.hahowdondon.data.dataJson
import hahow.recruit.hahowdondon.data.source.HaHowRepository
import hahow.recruit.hahowdondon.databinding.DialogClassLayoutBinding
import org.json.JSONObject

class HomeViewModel(
    private val haHowRepository: HaHowRepository,
) : ViewModel() {

    private val _classListInfo = MutableLiveData<ClassListInfo>()
    val classListInfo: LiveData<ClassListInfo>
        get() = _classListInfo

    private val _leaveDialog = MutableLiveData<Boolean?>()
    val leaveDialog: LiveData<Boolean?>
        get() = _leaveDialog

    init {
        // pretend to get data.json from api
        _classListInfo.value = haHowRepository.fetchClassListInfo()
    }

    fun showAbout(context: Context, classInfo: ClassInfo) {

        val binding = DialogClassLayoutBinding.inflate(LayoutInflater.from(context))
        binding.classInfo = classInfo
        val dialog = MaterialAlertDialogBuilder(context)
            .setView(binding.root)
            .create()
        binding.confirmButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setOnDismissListener {
            _leaveDialog.value = true
        }
        dialog.show()
    }

    fun leaveDialogComplete() {
        _leaveDialog.value = null
    }
}