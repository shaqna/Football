package com.maou.footballstandings.presentation.screens.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.maou.footballstandings.presentation.navigations.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Dashboard")
                }
            )
        }
    ) {innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            ElevatedButton(onClick = {
                navController.navigate(Screen.Club.route)
            }) {
                Text(text = "Input Club Data")
            }
            ElevatedButton(onClick = {
                navController.navigate(Screen.Score.route)
            }) {
                Text(text = "Input Score")
            }
            ElevatedButton(onClick = {
                navController.navigate(Screen.ScoreBoard.route)
            }) {
                Text(text = "View Scoreboard")
            }
        }
    }


}