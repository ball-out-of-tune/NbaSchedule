package com.example.nbaschedule.data

import androidx.annotation.DrawableRes
import com.example.nbaschedule.R

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

data class Match(
    val matchId: Int,
    val homePlayer: List<PlayerData>,
    val guestPlayer: List<PlayerData>
)

data class PlayerData(
    val playerName: String,
    val minutes: String,
    val points: Int,
    val rebounds: Int,
    val assists: Int,
    val steals: Int,
    val blocks: Int
)
object ScheduleRepository {
    val nbaSchedules = listOf<NbaScheduleWithImage>(
        NbaScheduleWithImage(
            id = 1,
            matchDate = "2024-4-21",
            matchTime = "01:00",
            homeTeam = "Cleveland Cavaliers",
            awayTeam = "Orlando Magic",
            homeTeamScore = 97,
            awayTeamScore = 83,
            isFinished = true,
            homeTeamIcon = R.drawable.cle,
            awayTeamIcon = R.drawable.orl,
        ) ,
        NbaScheduleWithImage(
            id = 2,
            matchDate = "2024-4-21",
            matchTime = "03:30",
            homeTeam = "Minnesota Timberwolves",
            awayTeam = "Phoenix Suns",
            homeTeamScore = 120,
            awayTeamScore = 95,
            isFinished = true,
            homeTeamIcon = R.drawable.min,
            awayTeamIcon = R.drawable.phx,
        ),

        NbaScheduleWithImage(
            id = 3,
            matchDate = "2024-4-21",
            matchTime = "06:00",
            homeTeam = "New York Knicks",
            awayTeam = "Philadelphia 76ers",
            homeTeamScore = 111,
            awayTeamScore = 104,
            isFinished = true,
            homeTeamIcon = R.drawable.nyk,
            awayTeamIcon = R.drawable.phi,
        ),

        NbaScheduleWithImage(
            id = 4,
            matchDate = "2024-4-21",
            matchTime = "08:30",
            homeTeam = "Denver Nuggets",
            awayTeam = "Los Angeles Lakers",
            homeTeamScore = 114,
            awayTeamScore = 103,
            isFinished = true,
            homeTeamIcon = R.drawable.den,
            awayTeamIcon = R.drawable.lal,
        ),

        NbaScheduleWithImage(
            id = 5,
            matchDate = "2024-4-22",
            matchTime = "01:00",
            homeTeam = "Boston Celtics",
            awayTeam = "Miami Heat",
            homeTeamScore = 114,
            awayTeamScore = 94,
            isFinished = true,
            homeTeamIcon = R.drawable.bos,
            awayTeamIcon = R.drawable.mia,
        ),

        NbaScheduleWithImage(
            id = 6,
            matchDate = "2024-4-22",
            matchTime = "03:30",
            homeTeam = "LA Clippers",
            awayTeam = "Dallas Mavericks",
            homeTeamScore = 109,
            awayTeamScore = 97,
            isFinished = true,
            homeTeamIcon = R.drawable.lac,
            awayTeamIcon = R.drawable.dal,
        ),

        NbaScheduleWithImage(
            id = 7,
            matchDate = "2024-4-22",
            matchTime = "07:00",
            homeTeam = "Milwaukee Bucks",
            awayTeam = "Indiana Pacers",
            homeTeamScore = 109,
            awayTeamScore = 94,
            isFinished = true,
            homeTeamIcon = R.drawable.mil,
            awayTeamIcon = R.drawable.ind,
        ),

        NbaScheduleWithImage(
            id = 8,
            matchDate = "2024-4-22",
            matchTime = "09:30",
            homeTeam = "Oklahoma City Thunder",
            awayTeam = "New Orleans Pelicans",
            homeTeamScore = 94,
            awayTeamScore = 92,
            isFinished = true,
            homeTeamIcon = R.drawable.okc,
            awayTeamIcon = R.drawable.nol,
        ),

        NbaScheduleWithImage(
            id = 9,
            matchDate = "2024-4-23",
            matchTime = "07:00",
            homeTeam = "Cleveland Cavaliers",
            awayTeam = "Orlando Magic",
            homeTeamScore = 96,
            awayTeamScore = 86,
            isFinished = true,
            homeTeamIcon = R.drawable.cle,
            awayTeamIcon = R.drawable.orl,
        ),

        NbaScheduleWithImage(
            id = 10,
            matchDate = "2024-4-23",
            matchTime = "07:30",
            homeTeam = "New York Knicks",
            awayTeam = "Philadelphia 76ers",
            homeTeamScore = 104,
            awayTeamScore = 101,
            isFinished = true,
            homeTeamIcon = R.drawable.nyk,
            awayTeamIcon = R.drawable.phi,
        ),

        NbaScheduleWithImage(
            id = 11,
            matchDate = "2024-4-23",
            matchTime = "09:30",
            homeTeam = "Denver Nuggets",
            awayTeam = "Los Angeles Lakers",
            homeTeamScore = 101,
            awayTeamScore = 99,
            isFinished = true,
            homeTeamIcon = R.drawable.den,
            awayTeamIcon = R.drawable.lal,
        ),

        NbaScheduleWithImage(
            id = 12,
            matchDate = "2024-4-24",
            matchTime = "07:30",
            homeTeam = "Minnesota Timberwolves",
            awayTeam = "Phoenix Suns",
            homeTeamScore = 105,
            awayTeamScore = 93,
            isFinished = true,
            homeTeamIcon = R.drawable.min,
            awayTeamIcon = R.drawable.phx,
        ),

        NbaScheduleWithImage(
            id = 13,
            matchDate = "2024-4-24",
            matchTime = "08:30",
            homeTeam = "Milwaukee Bucks",
            awayTeam = "Indiana Pacers",
            homeTeamScore = 108,
            awayTeamScore = 125,
            isFinished = true,
            homeTeamIcon = R.drawable.mil,
            awayTeamIcon = R.drawable.ind,
        ),

        NbaScheduleWithImage(
            id = 14,
            matchDate = "2024-4-24",
            matchTime = "10:00",
            homeTeam = "LA Clippers",
            awayTeam = "Dallas Mavericks",
            homeTeamScore = 93,
            awayTeamScore = 96,
            isFinished = true,
            homeTeamIcon = R.drawable.lac,
            awayTeamIcon = R.drawable.dal,
        ),

        NbaScheduleWithImage(
            id = 15,
            matchDate = "2024-4-25",
            matchTime = "07:00",
            homeTeam = "Boston Celtics",
            awayTeam = "Miami Heat",
            homeTeamScore = 101,
            awayTeamScore = 111,
            isFinished = true,
            homeTeamIcon = R.drawable.bos,
            awayTeamIcon = R.drawable.mia,
        ),

        NbaScheduleWithImage(
            id = 16,
            matchDate = "2024-4-25",
            matchTime = "09:30",
            homeTeam = "Oklahoma City Thunder",
            awayTeam = "New Orleans Pelicans",
            homeTeamScore = 124,
            awayTeamScore = 92,
            isFinished = true,
            homeTeamIcon = R.drawable.okc,
            awayTeamIcon = R.drawable.nol,
        ),

        NbaScheduleWithImage(
            id = 17,
            matchDate = "2024-4-26",
            matchTime = "07:00",
            homeTeam = "Orlando Magic",
            awayTeam = "Cleveland Cavaliers",
            homeTeamScore = 121,
            awayTeamScore = 83,
            isFinished = true,
            homeTeamIcon = R.drawable.orl,
            awayTeamIcon = R.drawable.cle,
        ),

        NbaScheduleWithImage(
            id = 18,
            matchDate = "2024-4-26",
            matchTime = "07:30",
            homeTeam = "Philadelphia 76ers",
            awayTeam = "New York Knicks",
            homeTeamScore = 125,
            awayTeamScore = 114,
            isFinished = true,
            homeTeamIcon = R.drawable.phi,
            awayTeamIcon = R.drawable.nyk,
        ),

        NbaScheduleWithImage(
            id = 19,
            matchDate = "2024-4-26",
            matchTime = "10:00",
            homeTeam = "Los Angeles Lakers",
            awayTeam = "Denver Nuggets",
            homeTeamScore = 105,
            awayTeamScore = 112,
            isFinished = true,
            homeTeamIcon = R.drawable.lal,
            awayTeamIcon = R.drawable.den,
        ),

        NbaScheduleWithImage(
            id = 20,
            matchDate = "2024-4-27",
            matchTime = "05:30",
            homeTeam = "Indiana Pacers",
            awayTeam = "Milwaukee Bucks",
            homeTeamScore = 121,
            awayTeamScore = 118,
            isFinished = true,
            homeTeamIcon = R.drawable.ind,
            awayTeamIcon = R.drawable.mil,
        ),

        NbaScheduleWithImage(
            id = 21,
            matchDate = "2024-4-27",
            matchTime = "08:00",
            homeTeam = "Dallas Mavericks",
            awayTeam = "LA Clippers",
            homeTeamScore = 101,
            awayTeamScore = 90,
            isFinished = true,
            homeTeamIcon = R.drawable.dal,
            awayTeamIcon = R.drawable.lac,
        ),

        NbaScheduleWithImage(
            id = 22,
            matchDate = "2024-4-27",
            matchTime = "10:30",
            homeTeam = "Phoenix Suns",
            awayTeam = "Minnesota Timberwolves",
            homeTeamScore = 126,
            awayTeamScore = 109,
            isFinished = true,
            homeTeamIcon = R.drawable.phx,
            awayTeamIcon = R.drawable.min,
        ),

        NbaScheduleWithImage(
            id = 23,
            matchDate = "2024-4-28",
            matchTime = "01:00",
            homeTeam = "Cleveland Cavaliers",
            awayTeam = "Orlando Magic",
            homeTeamScore = 112,
            awayTeamScore = 89,
            isFinished = true,
            homeTeamIcon = R.drawable.cle,
            awayTeamIcon = R.drawable.orl,
        ),

        NbaScheduleWithImage(
            id = 24,
            matchDate = "2024-4-28",
            matchTime = "03:30",
            homeTeam = "New Orleans Pelicans",
            awayTeam = "Oklahoma City Thunder",
            homeTeamScore = 106,
            awayTeamScore = 85,
            isFinished = true,
            homeTeamIcon = R.drawable.nol,
            awayTeamIcon = R.drawable.okc,
        ),

        NbaScheduleWithImage(
            id = 25,
            matchDate = "2024-4-28",
            matchTime = "06:00",
            homeTeam = "Miami Heat",
            awayTeam = "Boston Celtics",
            homeTeamScore = 104,
            awayTeamScore = 84,
            isFinished = true,
            homeTeamIcon = R.drawable.mia,
            awayTeamIcon = R.drawable.bos,
        ),

        NbaScheduleWithImage(
            id = 26,
            matchDate = "2024-4-28",
            matchTime = "08:30",
            homeTeam = "Los Angeles Lakers",
            awayTeam = "Denver Nuggets",
            homeTeamScore = 119,
            awayTeamScore = 108,
            isFinished = true,
            homeTeamIcon = R.drawable.lal,
            awayTeamIcon = R.drawable.den,
        ),

        NbaScheduleWithImage(
            id = 27,
            matchDate = "2024-4-29",
            matchTime = "01:00",
            homeTeam = "Philadelphia 76ers",
            awayTeam = "New York Knicks",
            homeTeamScore = 0,
            awayTeamScore = 0,
            isFinished = false,
            homeTeamIcon = R.drawable.phi,
            awayTeamIcon = R.drawable.nyk,
        ),

        NbaScheduleWithImage(
            id = 28,
            matchDate = "2024-4-29",
            matchTime = "03:30",
            homeTeam = "Dallas Mavericks",
            awayTeam = "LA Clippers",
            homeTeamScore = 0,
            awayTeamScore = 0,
            isFinished = false,
            homeTeamIcon = R.drawable.dal,
            awayTeamIcon = R.drawable.lac,
        ),

        NbaScheduleWithImage(
            id = 29,
            matchDate = "2024-4-29",
            matchTime = "07:00",
            homeTeam = "Indiana Pacers",
            awayTeam = "Milwaukee Bucks",
            homeTeamScore = 0,
            awayTeamScore = 0,
            isFinished = false,
            homeTeamIcon = R.drawable.ind,
            awayTeamIcon = R.drawable.mil,
        ),

        NbaScheduleWithImage(
            id = 30,
            matchDate = "2024-4-29",
            matchTime = "09:30",
            homeTeam = "Phoenix Suns",
            awayTeam = "Minnesota Timberwolves",
            homeTeamScore = 0,
            awayTeamScore = 0,
            isFinished = false,
            homeTeamIcon = R.drawable.phx,
            awayTeamIcon = R.drawable.min,
        ),

        NbaScheduleWithImage(
            id = 31,
            matchDate = "2024-5-2",
            matchTime = "10:00",
            homeTeam = "LA Clippers",
            awayTeam = "Dallas Mavericks",
            homeTeamScore = 93,
            awayTeamScore = 123,
            isFinished = true,
            homeTeamIcon = R.drawable.lac,
            awayTeamIcon = R.drawable.dal,
        )
    )

    fun getMatch(newsId: Int?): NbaScheduleWithImage {
        return nbaSchedules.first {
            it.id == newsId
        }
    }
}

object PlayerDataList {
    val match = listOf<Match>(
        Match(
            matchId = 1,
            homePlayer = listOf<PlayerData>(
                PlayerData("Donovan Mitchell","36:00", 30 , 2, 3, 3, 4),
                PlayerData("Evan Mobley", "36:03" ,16, 11 , 2 ,0, 3),
                PlayerData("Jarrett Allen", "35:11",16, 18 , 0, 2, 2),
                PlayerData("Darius Garland", "32:23",14, 4, 8, 1, 0),
                PlayerData("Max Strus", "32:42",7 ,9 , 1, 1, 0),
            ),
            guestPlayer = listOf<PlayerData>(
                PlayerData("Jonathan Issac", "",10, 5, 1, 3, 3),
                PlayerData("Paolo Banchero", "",24 ,7, 5, 0, 0),
                PlayerData("Jalen Suggs", "",13, 4, 4, 2, 1),
                PlayerData("Franz Wagner", "",18, 7, 3,1,3),
                PlayerData("Markell Fultz", "",0 ,3, 1, 0 ,0),
            )
        ),
    )
    fun getMatch(id: Int): Match {
        return match.first {
            it.matchId == id
        }
    }
}

