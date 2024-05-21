package com.example.nbaschedule.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nbaschedule.data.PlayerDataList
import com.example.nbaschedule.data.ScheduleRepository

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object Detail: Destination("Detail")
}

@Composable
fun NbaSchedulePart() {
    val navController = rememberNavController()
    Scaffold(
    ) {innerPadding ->
        println(innerPadding)
        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) { TeamScheduleList(navController = navController) }
            composable(
                Destination.Detail.route+ "/{newsId}",
                arguments = listOf(navArgument("newsId") { type = NavType.IntType })
            ) { backStackEntry ->
                val newsId = backStackEntry.arguments?.getInt("newsId")
                    ?: error("newsId cannot be null")
                DetailScreen(
                    ScheduleRepository.getMatch(newsId),
                    PlayerDataList.getMatch(newsId)
                )
            }
        }
    }
}