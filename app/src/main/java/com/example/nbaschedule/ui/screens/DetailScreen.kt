package com.example.nbaschedule.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.errorLight
import com.example.compose.surfaceContainerHighestLight
import com.example.nbaschedule.R
import com.example.nbaschedule.data.Match
import com.example.nbaschedule.data.NbaScheduleWithImage
import com.example.nbaschedule.data.PlayerData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavController,
    nbaScheduleWithImage: NbaScheduleWithImage,
    match: Match
) {
    Scaffold(
        topBar = {
            DetailTopAppBar(
                nbaScheduleWithImage = nbaScheduleWithImage,
                onBackPressed = { navController.popBackStack() }
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopPart(nbaScheduleWithImage = nbaScheduleWithImage)
            TextPart()
            PlayerDataPart(match = match, nbaScheduleWithImage = nbaScheduleWithImage)
        }
    }
}
//自定义新闻详细信息的顶部导航栏
@Composable
fun DetailTopAppBar(
    nbaScheduleWithImage: NbaScheduleWithImage,
    onBackPressed: () -> Unit = {}
) {
    TopAppBar(title = {
        Text(text = nbaScheduleWithImage.homeTeam +
                " vs " +
                nbaScheduleWithImage.awayTeam,
            fontWeight = FontWeight.ExtraBold)
                      },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(imageVector = Icons.Default.ArrowBack, "")
            }
        },
        backgroundColor = surfaceContainerHighestLight
    )
}

@Composable
fun TopPart(nbaScheduleWithImage: NbaScheduleWithImage) {
    var scrollState = rememberScrollState()
    Card(
        modifier = Modifier
            .scrollable(scrollState, orientation = Orientation.Horizontal)
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .scrollable(scrollState, orientation = Orientation.Horizontal)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = nbaScheduleWithImage.awayTeamIcon
                ),
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(
                        minHeight = 40.dp,
                        minWidth = 40.dp,
                        maxHeight = 60.dp,
                        maxWidth = 60.dp
                    )
                    .fillMaxWidth()
                    .fillMaxHeight()
            )

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    modifier = Modifier,
                    text = nbaScheduleWithImage.awayTeam.substringBefore(" "),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    modifier = Modifier,
                    text = nbaScheduleWithImage.awayTeam.substringAfter(" "),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "客",
                    modifier = Modifier,
                    style = MaterialTheme.typography.body1)
            }

            Row(
                modifier = Modifier.fillMaxHeight(fraction = 0.1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = nbaScheduleWithImage.awayTeamScore.toString(),
                    style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.padding(4.dp),)
                Text(text = "VS",
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = nbaScheduleWithImage.homeTeamScore.toString(),
                    style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.padding(4.dp))
            }

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = nbaScheduleWithImage.homeTeam.substringBefore(" "),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = nbaScheduleWithImage.homeTeam.substringAfter(" "),
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "主",
                    style = MaterialTheme.typography.body1)
            }

            Image(
                painter = painterResource(
                    id = nbaScheduleWithImage.homeTeamIcon
                ),
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(
                        minHeight = 40.dp,
                        minWidth = 40.dp,
                        maxHeight = 60.dp,
                        maxWidth = 60.dp
                    )
                    .fillMaxWidth()
                    .fillMaxHeight()
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextPart() {
    Card(
        modifier = Modifier
        .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        onClick = { /*TODO*/ }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "请前往腾讯视频或者youtube等平台观看，网址:",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1)
            Text(text = "https://v.qq.com/",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )
            Text(text = "https://youtube.com",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerDataPart(
    match: Match,
    nbaScheduleWithImage: NbaScheduleWithImage
) {
    if (match.matchId != 0) {
        Card(
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "球员数据统计",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.h4
            )
        }

        var player: List<PlayerData> by remember {
            mutableStateOf(match.homePlayer)
        }

        Card(
            shape = RoundedCornerShape(0.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        if (player != match.guestPlayer)
                            player = match.guestPlayer
                    },
                    modifier = Modifier.weight(0.4f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = errorLight)
                ) {
                    Text(text = nbaScheduleWithImage.awayTeam.toString())
                }
//                Divider()
                Button(
                    onClick = {
                        if (player != match.homePlayer)
                            player = match.homePlayer
                    },
                    modifier = Modifier.weight(0.4f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = nbaScheduleWithImage.homeTeam.toString())
                }
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        LazyColumn(
        ) {
            itemsIndexed(
                items = player
            ) { index, singlePlayer ->
                PlayerDataItem(singlePlayer = singlePlayer)
            }
        }
    } else {
        Card(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(
                text = "球员数据还没有统计出来哟",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold
            )
        }

    }
}

@Composable
fun PlayerDataItem(singlePlayer: PlayerData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Player Name: ",
                    style = MaterialTheme.typography.subtitle1)
                Text(text = singlePlayer.playerName,
                    style = MaterialTheme.typography.h4)
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Minutes",
                        modifier = Modifier,
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold)
                    Text(text = singlePlayer.minutes,
                        style = MaterialTheme.typography.body1)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Points",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold)
                    Text(text = singlePlayer.points.toString(),
                        style = MaterialTheme.typography.body1)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "ReBounds",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold)
                    Text(text = singlePlayer.rebounds.toString(),
                        style = MaterialTheme.typography.body1)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Assists",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold)
                    Text(text = singlePlayer.assists.toString(),
                        style = MaterialTheme.typography.body1)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Steal",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold)
                    Text(text = singlePlayer.steals.toString(),
                        style = MaterialTheme.typography.body1)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Blocks",
                        style = MaterialTheme.typography.body1,
                        fontWeight = FontWeight.Bold)
                    Text(text = singlePlayer.blocks.toString(),
                        style = MaterialTheme.typography.body1)
                }
            }
        }
    }
    Spacer(modifier = Modifier.padding(8.dp))
}

@Preview
@Composable
fun DetailScreenPreview() {
    val nbaScheduleWithImage = NbaScheduleWithImage(
        awayTeamScore = 101,
        homeTeam = "lal",
        homeTeamScore = 120,
        awayTeamIcon = R.drawable.den,
        homeTeamIcon = R.drawable.lal,
        awayTeam = "den",
        id = 211,
        isFinished = true,
        matchTime = "10:00",
        matchDate = "2024-5-21"
    )
    val match = Match(
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
    )
    DetailScreen(
        navController = rememberNavController(),
        nbaScheduleWithImage = nbaScheduleWithImage,
        match = match
    )
}

/*
@Preview
@Composable
fun PlayerDataItemPreview() {
    val singlePlayer: PlayerData = PlayerData("Donovan Mitchell","36:00", 30 , 2, 3, 3, 4)
    PlayerDataItem(singlePlayer = singlePlayer)
}*/
