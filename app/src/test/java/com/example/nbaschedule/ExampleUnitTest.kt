package com.example.nbaschedule

import android.util.Log
import com.example.nbaschedule.data.NbaSchedule
import com.example.nbaschedule.data.NbaScheduleRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun NbaScheduleCorrectness() {
//        assertEquals(4,4)
        /*        for (item in NbaScheduleRepository.fullNbaScheduleWithImage) {

        }*/
        assertEquals("Cleveland Cavaliers", NbaScheduleRepository.fullNbaSchedule[0].homeTeam)
//        Log.d("1", NbaScheduleRepository.fullSchedule[0].homeTeam)
    }
}