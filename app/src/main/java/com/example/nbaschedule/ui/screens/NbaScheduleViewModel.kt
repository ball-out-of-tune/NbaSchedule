package com.example.nbaschedule.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.nbaschedule.NbaScheduleApplication
import com.example.nbaschedule.data.NbaSchedule
import com.example.nbaschedule.data.NbaScheduleDao
import kotlinx.coroutines.flow.Flow

class NbaScheduleViewModel(private val nbaScheduleDao: NbaScheduleDao): ViewModel() {
    // Get full bus schedule from Room DB
    fun getFullSchedule(): Flow<List<NbaSchedule>> = nbaScheduleDao.getAllSchedule()
    // Get bus schedule based on the stop name from Room DB
    fun getScheduleFor(teamName: String): Flow<List<NbaSchedule>> =
        nbaScheduleDao.getByTeamName(teamName)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NbaScheduleApplication)
                NbaScheduleViewModel(application.database.nbaScheduleDao())
            }
        }
    }
}
