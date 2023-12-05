package com.maou.footballstandings.presentation.navigations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maou.footballstandings.presentation.screens.club.ClubScreen
import com.maou.footballstandings.presentation.screens.club.ClubViewModel
import com.maou.footballstandings.presentation.screens.dashboard.DashboardScreen
import com.maou.footballstandings.presentation.screens.score.AddOneByOneScreen
import com.maou.footballstandings.presentation.screens.score.ScoreBoardScreen
import com.maou.footballstandings.presentation.screens.score.ScoreScreen
import com.maou.footballstandings.presentation.screens.score.ScoreViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun NavGraphSetup(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {

    val context = LocalContext.current
    NavHost(
        navController = navHostController,
        startDestination = Screen.Dashboard.route,
        route = "/"
    ) {
        composable(route = Screen.Dashboard.route) {
            DashboardScreen(navController = navHostController)
        }

        composable(route = Screen.Club.route) {

            val viewModel = koinViewModel<ClubViewModel>()
            val state by viewModel.clubUiState.collectAsState()
            ClubScreen(
                navController = navHostController,
                context = context,
                state = state,
                clubViewModel = viewModel
            )
        }

        scoreGraph(navHostController)

        composable(route = Screen.ScoreBoard.route) {
            val viewModel = koinViewModel<ScoreViewModel>()
            val state by viewModel.stateClubs.collectAsState()
            ScoreBoardScreen(context = context, viewModel = viewModel, state = state)
        }
    }
}

fun NavGraphBuilder.scoreGraph(
    navHostController: NavHostController,
) {
    composable(Screen.Score.route) {
        ScoreScreen(navController = navHostController)
    }

    composable(Screen.AddOneByOneScore.route) {
        val context = LocalContext.current
        val viewModel = koinViewModel<ScoreViewModel>()
        val state by viewModel.state.collectAsState()
        AddOneByOneScreen(
            navController = navHostController,
            viewModel = viewModel,
            state = state,
            context = context
        )
    }

}