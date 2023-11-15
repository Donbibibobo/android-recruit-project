package hahow.recruit.hahowdondon.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hahow.recruit.hahowdondon.data.source.HaHowRepository
import hahow.recruit.hahowdondon.home.HomeViewModel

// Factory for all ViewModels
@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val haHowRepository: HaHowRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) ->
                    HomeViewModel(haHowRepository)

                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
