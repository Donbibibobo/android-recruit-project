package hahow.recruit.hahowdondon.data.source

import hahow.recruit.hahowdondon.data.ClassListInfo

class DefaultHaHowRepository(
    private val haHowRemoteDataSource: HaHowDataSource,
    private val haHowLocalDataSource: HaHowDataSource,
): HaHowRepository {

    override fun fetchClassListInfo(): ClassListInfo? {
        return haHowRemoteDataSource.fetchClassListInfo()
    }
}