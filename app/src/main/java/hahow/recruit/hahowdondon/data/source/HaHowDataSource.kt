package hahow.recruit.hahowdondon.data.source

import hahow.recruit.hahowdondon.data.ClassListInfo

interface HaHowDataSource {
    fun fetchClassListInfo(): ClassListInfo?
}