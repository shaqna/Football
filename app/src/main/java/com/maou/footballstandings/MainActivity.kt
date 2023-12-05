package com.maou.footballstandings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.maou.footballstandings.presentation.navigations.NavGraphSetup
import com.maou.footballstandings.ui.theme.FootballStandingsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballStandingsTheme {
                val navHostController = rememberNavController()
                NavGraphSetup(navHostController = navHostController)
            }
        }
    }
}
