package com.example.nbaschedule

import android.content.res.Configuration
import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.nbaschedule.data.NbaSchedule
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.nbaschedule.data.NbaScheduleRepository
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource

enum class NbaScheduleScreens {
    FullSchedule,
    PlayerStat
}


@Composable
fun NbaScheduleApp(
    viewModel: NbaScheduleViewModel = viewModel(factory = NbaScheduleViewModel.factory)
) {
    val navController = rememberNavController()

    val fullSchedule by viewModel.getFullSchedule().collectAsState(emptyList())

    Scaffold(
        topBar = {

        }
    ) {
        innerPadding ->
        println(innerPadding)

    }
}

@Composable
fun FullScheduleScreen(

) {

}

@Composable
fun NbaScheduleScreen(
    nbaSchedules: List<NbaSchedule>,
    modifier: Modifier = Modifier,

) {
}


@Composable
fun TeamScheduleList(
    schedule: List<NbaSchedule>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    ) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
    ) {
        this.items(
            items = schedule,
            key = {schedule -> schedule.id}
        ) {

        }
    }
}

@Composable
fun TeamScheduleItem(
    singleSchedule: NbaSchedule,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = singleSchedule.matchTime,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "季后赛",
                    textAlign = TextAlign.Center
                )
            }

            Column() {
                val homeTeamIconId = detectTeamIcon(singleSchedule.homeTeam)
                val awayTeamIconId = detectTeamIcon(singleSchedule.awayTeam)
                Row {
                    Image(painter = painterResource(id = homeTeamIconId),
                        contentDescription = "",
                        modifier = modifier.sizeIn(
                            minHeight = 12.dp,
                            minWidth = 16.dp,
                            maxHeight = 16.dp,
                            maxWidth = 20.dp
                        )
                    )
                    Text(text = singleSchedule.awayTeam)
                }
                Row() {
                    Image(painter = painterResource(id = awayTeamIconId),
                        contentDescription = "",
                        modifier = modifier.sizeIn(
                            minHeight = 12.dp,
                            minWidth = 16.dp,
                            maxHeight = 16.dp,
                            maxWidth = 20.dp
                        )
                    )
                    Text(text = singleSchedule.homeTeam)
                }


            }
        }
    }
}


@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val oneSingleGame = NbaSchedule(
        1,
        "2024-4-21 01:00",
        "Cleveland Cavaliers",
        "Orlando Magic",
        97,
        83,
        true,
        R.drawable.cle,
        R.drawable.orl
    )
//    val theSecondGame = NbaScheduleRepository.fullNbaSchedule[3]
    MaterialTheme {
        TeamScheduleItem(
            singleSchedule = oneSingleGame,
        )
    }
}

/*@Preview
@Composable
fun HeroesPreview() {
    SuperheroesTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            *//* Important: It is not a good practice to access data source directly from the UI.
            In later units you will learn how to use ViewModel in such scenarios that takes the
            data source as a dependency and exposes heroes.
            *//*
            HeroesList(heroes = HeroesRepository.heroes)
        }
    }
}*/


val teamList = listOf(
    "Cleveland Cavaliers", "Orlando Magic", "Minnesota Timberwolves", "Phoenix Suns",
    "New York Knicks", "Philadelphia 76ers", "Denver Nuggets", "Los Angeles Lakers",
    "Boston Celtics", "Miami Heat", "LA Clippers", "Dallas Mavericks",
    "Milwaukee Bucks", "Indiana Pacers", "Oklahoma City Thunder", "New Orleans Pelicans"
)

fun detectTeamIcon(ateam: String): Int {
        if (ateam == "Cleveland Cavaliers" )
            return R.drawable.cle
        else if (ateam == "Orlando Magic")
            return R.drawable.orl
        else if (ateam == "Minnesota Timberwolves")
            return R.drawable.min
        else if (ateam == "Phoenix Suns")
            return R.drawable.phx
        else if (ateam == "New York Knicks")
            return R.drawable.nyk
        else if (ateam == "Philadelphia 76ers")
            return R.drawable.phi
        else if (ateam == "Denver Nuggets")
            return R.drawable.den
        else if (ateam == "Los Angeles Lakers")
            return R.drawable.lal
        else if (ateam == "Boston Celtics")
            return R.drawable.bos
        else if (ateam == "Miami Heat")
            return R.drawable.mia
        else if (ateam == "Oklahoma City Thunder")
            return R.drawable.okc
        else if (ateam == "New Orleans Pelicans")
            return R.drawable.nol
        else if (ateam == "LA Clippers")
            return R.drawable.lac
        else if (ateam == "Dallas Mavericks")
            return R.drawable.dal
        else if (ateam == "Milwaukee Bucks")
            return R.drawable.mil
        else if (ateam == "Indiana Pacers")
            return R.drawable.ind
        else
            return 0
}

fun returnTeamIcon() {

}