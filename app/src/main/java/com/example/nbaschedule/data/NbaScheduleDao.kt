package com.example.nbaschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NbaScheduleDao {
    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY matchTime ASC    
        """
    )
    fun getAllSchedule(): Flow<List<NbaSchedule>>

    @Query(
        """
        SELECT * FROM schedule 
        WHERE homeTeam = :teamName or awayTeam = :teamName 
        ORDER BY matchTime ASC 
        """
    )
    fun getByTeamName(teamName: String): Flow<List<NbaSchedule>>
}