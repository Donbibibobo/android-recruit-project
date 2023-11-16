package hahow.recruit.hahowdondon.data.source.remote

import android.util.Log
import hahow.recruit.hahowdondon.data.ClassListInfo
import hahow.recruit.hahowdondon.data.dataJson
import hahow.recruit.hahowdondon.data.source.HaHowDataSource
import hahow.recruit.hahowdondon.network.moshi

class HaHowRemoteDataSource: HaHowDataSource {

    // pretend to call api and fetch data.json
    override fun fetchClassListInfo(): ClassListInfo? {
        val adapter = moshi.adapter(ClassListInfo::class.java)
        return try {
            adapter.fromJson(dataJson)
        } catch (e: Exception) {
            Log.i("fetchClassListInfo", "fetchClassListInfo error: $e")
            null
        }
    }
}