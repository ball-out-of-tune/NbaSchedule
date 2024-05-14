package com.example.nbaschedule.data

//import com.example.nbaschedule.NbaScheduleApplication

import androidx.annotation.DrawableRes
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nbaschedule.NbaScheduleApplication
import com.example.nbaschedule.NbaScheduleViewModel
import com.example.nbaschedule.R
import com.example.nbaschedule.data.NbaScheduleRepository.fullNbaSchedule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlin.math.truncate

object NbaScheduleRepository {
    val application = NbaScheduleApplication()
    val dao = application.database.nbaScheduleDao()
    val fullSchedule = dao.getAll()
    val fullNbaSchedule = convert(fullSchedule)
//    val fullNbaScheduleWithImage = toNbaScheduleWithImage(fullNbaSchedule)
}

data class NbaScheduleWithImage(
    val id: Int,

    val matchDate: String,

    val matchTime: String,

    val homeTeam: String,

    val awayTeam: String,

    val homeTeamScore: Int,

    val awayTeamScore: Int,

    val isFinished: Boolean,

    @DrawableRes
    val homeTeamIcon: Int,

    @DrawableRes
    val awayTeamIcon: Int
)



suspend fun convertFlowToList(flow: Flow<List<NbaSchedule>>): List<NbaSchedule> {
    val resultList = mutableListOf<NbaSchedule>()
    flow.collect { list ->
        resultList.addAll(list)
    }
    return resultList
}

fun convert(fullSchedule: Flow<List<NbaSchedule>>) = runBlocking {
    convertFlowToList(fullSchedule)
}

fun NbaSchedule.toNbaScheduleWithImage(): NbaScheduleWithImage = NbaScheduleWithImage(
    id = id,
    matchDate = "",
    matchTime = matchTime,
    homeTeam = homeTeam,
    awayTeam = awayTeam,
    homeTeamScore = homeTeamScore,
    awayTeamScore = awayTeamScore,
    isFinished = isFinished,
    homeTeamIcon = 0,
    awayTeamIcon = 0
)

fun toNbaScheduleWithImage(fullSchedule: List<NbaSchedule>): List<NbaScheduleWithImage> {
    lateinit var fullNbaScheduleWithImage: MutableList<NbaScheduleWithImage>
    for (item in fullNbaSchedule) {
        fullNbaScheduleWithImage.add(item.toNbaScheduleWithImage())
    }
    return fullNbaScheduleWithImage
}

/*
object NbaScheduleRepository {
    val application = NbaScheduleApplication()
    val dao = application.database.nbaScheduleDao()
    val fullSchedule = dao.getAll()
}
*/
