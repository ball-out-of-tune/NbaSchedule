package com.example.nbaschedule

import android.app.Application
import com.example.nbaschedule.data.AppDatabase
import com.example.nbaschedule.data.NbaScheduleDao

class NbaScheduleApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}


