package hahow.recruit.hahowdondon.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {


    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    init {
        _status.value = "aa"
    }
}