package hahow.recruit.hahowdondon.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hahow.recruit.hahowdondon.data.ClassListInfo
import hahow.recruit.hahowdondon.data.dataJson
import hahow.recruit.hahowdondon.data.source.HaHowRepository
import org.json.JSONObject

class HomeViewModel(
    private val haHowRepository: HaHowRepository,
    ): ViewModel() {


    private val _classListInfo = MutableLiveData<ClassListInfo>()
    val classListInfo: LiveData<ClassListInfo>
        get() = _classListInfo



    init {
        _classListInfo.value = haHowRepository.fetchClassListInfo()

    }
}