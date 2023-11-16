package hahow.recruit.hahowdondon.util

import android.content.Context
import androidx.annotation.VisibleForTesting
import hahow.recruit.hahowdondon.data.source.DefaultHaHowRepository
import hahow.recruit.hahowdondon.data.source.HaHowDataSource
import hahow.recruit.hahowdondon.data.source.HaHowRepository
import hahow.recruit.hahowdondon.data.source.local.HaHowLocalDataSource
import hahow.recruit.hahowdondon.data.source.remote.HaHowRemoteDataSource

object ServiceLocator {

    @Volatile
    var haHowRepository: HaHowRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(context: Context): HaHowRepository {
        synchronized(this) {
            return haHowRepository
                ?: createHaHowRepository(context)
        }
    }

    private fun createHaHowRepository(context: Context): HaHowRepository {
        return DefaultHaHowRepository(
            HaHowRemoteDataSource,
            createLocalDataSource(context)
        )
    }

    // can use context to create Room here if needed
    private fun createLocalDataSource(context: Context): HaHowDataSource {
        return HaHowLocalDataSource()
    }
}