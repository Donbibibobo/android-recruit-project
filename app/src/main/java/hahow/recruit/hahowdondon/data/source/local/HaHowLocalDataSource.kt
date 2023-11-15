package hahow.recruit.hahowdondon.data.source.local

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import hahow.recruit.hahowdondon.data.ClassListInfo
import hahow.recruit.hahowdondon.data.dataJson
import hahow.recruit.hahowdondon.data.source.HaHowDataSource
import hahow.recruit.hahowdondon.network.moshi

class HaHowLocalDataSource(): HaHowDataSource {

    override fun fetchClassListInfo(): ClassListInfo?{

        // pretend to call api and get [data.json] here
        val adapter = moshi.adapter(ClassListInfo::class.java)
        return try {
            adapter.fromJson(dataJson)
        } catch (e: Exception) {
            Log.i("fetchClassListInfo", "fetchClassListInfo error: $e")
            null
        }


    }
}