package hahow.recruit.hahowdondon.data.source

import hahow.recruit.hahowdondon.data.ClassListInfo

interface HaHowRepository {   // Data Loader

    fun fetchClassListInfo(): ClassListInfo?
}