package com.example.nbaschedule.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size


import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.compose.AppTheme
import com.example.nbaschedule.R
import com.example.nbaschedule.data.NbaScheduleWithImage
import kotlinx.coroutines.launch
import com.example.nbaschedule.data.ScheduleRepository
import com.example.nbaschedule.data.toNbaScheduleWithImage

enum class NbaScheduleScreens {
    FullSchedule,
    PlayerStat
}

@Composable
fun TeamScheduleList(
    schedule: List<NbaScheduleWithImage> = ScheduleRepository.nbaSchedules,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    navController: NavController = rememberNavController()
) {
    lateinit var date: String
    val listState = rememberLazyListState()
// Remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
    ) {
        itemsIndexed(
            items = schedule
        ) {index, scheduleItem ->
            if (index == 0 || scheduleItem.matchDate != date) {
                DateBar(scheduleItem)
            }
            date = scheduleItem.matchDate
            TeamScheduleItem(
                singleSchedule = scheduleItem,
                modifier = Modifier,
                onClick = {navController.navigate("Detail/${scheduleItem.id}")}
            )
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    // Animate scroll to the first item
                    listState.animateScrollToItem(index = 0)
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    bottom = 8.dp,
                    end = 8.dp
                )
        ) {
            Text(text = "Click")
        }
    }
}

@Composable
fun TeamScheduleItem(
    singleSchedule: NbaScheduleWithImage,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .padding(4.dp)
            .clickable { onClick() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .sizeIn(minHeight = 72.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment =  Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
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

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val homeTeamIconId = detectTeamIcon(singleSchedule.homeTeam)
                val awayTeamIconId = detectTeamIcon(singleSchedule.awayTeam)
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = awayTeamIconId),
                        contentDescription = "",
                        modifier = modifier.sizeIn(
                            minHeight = 20.dp,
                            minWidth = 20.dp,
                            maxHeight = 28.dp,
                            maxWidth = 28.dp
                        )
                    )
                    Text(text = singleSchedule.homeTeam)
                }


            }
            if( singleSchedule.isFinished) {
                Column() {
                    Text(text = singleSchedule.homeTeamScore.toString())
                    Text(text = singleSchedule.awayTeamScore.toString())
                }
            } else {
                Column() {
                    Text(text = "--")
                    Text(text = "--")
                }
            }

            if (singleSchedule.isFinished) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "已结束")
                }
            } else {
                Column {
                    Text(text = "未开始")
                }
            }
        }
    }
}

@Composable
fun DateBar(
    singleSchedule: NbaScheduleWithImage
) {
    if (singleSchedule.id != 1) {
        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    start = 1.dp,
                    end = 1.dp
                )
        )
    }
    Card() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(maxHeight = 20.dp)
        ) {
            Text(text = singleSchedule.matchDate.toString())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scheduleTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(
                            width = 4.dp,
                            height = 8.dp
                        )
                        .padding(2.dp),
                    painter = painterResource(R.drawable.nba),
                    // Content Description is not needed here - image is decorative, and setting a
                    // null content description allows accessibility services to skip this element
                    // during navigation.

                    contentDescription = "NBA logo"
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

//这个list暂时应该没用
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


@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroItemPreview() {
    val oneSingleGame = NbaScheduleWithImage(
        1,
        "2024-4-21",
        "01:00",
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
            onClick = {}
        )
    }
}

@Preview
@Composable
fun HeroesPreview() {
    AppTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            TeamScheduleList(
                schedule = ScheduleRepository.nbaSchedules,
                navController = rememberNavController()
            )
        }
    }
}


//这个组合函数可能没啥用了
@Composable
fun NbaScheduleApp(
    viewModel: NbaScheduleViewModel = viewModel(factory = NbaScheduleViewModel.factory)
) {
    val navController = rememberNavController()
    val fullSchedule by viewModel.getFullSchedule().collectAsState(emptyList())
    lateinit var scheduleWithImage: MutableList<NbaScheduleWithImage>
    for (schedule in fullSchedule) {
        scheduleWithImage.add(schedule.toNbaScheduleWithImage())
    }
    Scaffold(
        topBar = {
            scheduleTopAppBar()
        }
    ) {
            innerPadding ->
        TeamScheduleList(
            schedule = ScheduleRepository.nbaSchedules,
            contentPadding = innerPadding,
            navController = navController
        )
    }
}


@Preview
@Composable
fun ScheduleScreenPreview() {
    AppTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            NbaScheduleApp()
        }
    }
}


