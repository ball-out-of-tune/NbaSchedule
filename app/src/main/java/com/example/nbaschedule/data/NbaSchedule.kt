package com.example.nbaschedule.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Schedule")
data class BusSchedule(
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

    @ColumnInfo(name = "homeTeamScore")
    val isFinished: Boolean
)