package hahow.recruit.hahowdondon.data

data class ClassListInfo(
    val data: List<ClassInfo>
)

data class ClassInfo(
    val successCriteria: SuccessCriteria,
    val numSoldTickets: Int,
    val status: String,
    val proposalDueTime: String?,
    val coverImageUrl: String,
    val title: String
)

data class SuccessCriteria(
    val numSoldTickets: Int
)
