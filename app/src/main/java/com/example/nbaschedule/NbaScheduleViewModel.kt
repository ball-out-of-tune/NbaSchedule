package com.example.nbaschedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.nbaschedule.data.NbaSchedule
import com.example.nbaschedule.data.NbaScheduleDao
import kotlinx.coroutines.flow.Flow

class NbaScheduleViewModel(private val nbaScheduleDao: NbaScheduleDao): ViewModel() {
    // Get full bus schedule from Room DB
    fun getFullSchedule(): Flow<List<NbaSchedule>> = nbaScheduleDao.getAll()
    // Get bus schedule based on the stop name from Room DB
    fun getScheduleFor(teamName: String): Flow<List<NbaSchedule>> =
        nbaScheduleDao.getByTeamName(teamName)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as NbaScheduleApplication)
                NbaScheduleViewModel(application.database.nbaScheduleDao())
            }
        }
    }
}
