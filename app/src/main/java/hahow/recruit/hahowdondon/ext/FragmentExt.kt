package hahow.recruit.hahowdondon.ext

import androidx.fragment.app.Fragment
import hahow.recruit.hahowdondon.HaHowApplication
import hahow.recruit.hahowdondon.factory.ViewModelFactory

fun Fragment.getVmFactory(): ViewModelFactory {

    val repository = (requireContext().applicationContext as HaHowApplication).haHowRepository
    return ViewModelFactory(repository)
}