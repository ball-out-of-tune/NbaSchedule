package com.example.nbaschedule.data

import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Schedule")
data class NbaSchedule(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "matchTime")
    val matchTime: String,

    @ColumnInfo(name = "homeTeam")
    val homeTeam: String,

    @ColumnInfo(name = "awayTeam")
    val awayTeam: String,

    @ColumnInfo(name = "homeTeamScore")
    val homeTeamScore: Int,

    @ColumnInfo(name = "awayTeamScore")
    val awayTeamScore: Int,

    @ColumnInfo(name = "isFinished")
    val isFinished: Boolean,
) {
    fun ToNbaScheduleWithImage(): NbaScheduleWithImage {
        return NbaScheduleWithImage(
            id = id,
            matchDate = matchTime.substring(5, 9),
            matchTime = matchTime.substring(10, 15),
            homeTeam = homeTeam,
            awayTeam = awayTeam,
            homeTeamScore = homeTeamScore,
            awayTeamScore = awayTeamScore,
            isFinished = isFinished,
            homeTeamIcon = 0,
            awayTeamIcon = 0
        )
    }
}

