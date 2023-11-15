package hahow.recruit.hahowdondon

import android.app.Application
import hahow.recruit.hahowdondon.data.source.HaHowRepository
import hahow.recruit.hahowdondon.util.ServiceLocator
import kotlin.properties.Delegates

// An application that lazily provides a repository
class HaHowApplication : Application() {

    // Depends on the flavor
    val haHowRepository: HaHowRepository
        get() = ServiceLocator.provideTasksRepository(this)

    companion object {
        var instance: HaHowApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}