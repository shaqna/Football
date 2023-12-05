package com.maou.footballstandings.presentation.navigations

sealed class Screen(val route: String) {
    object Dashboard: Screen("dashboard_screen")
    object Club: Screen("club_screen")
    object Score: Screen("score_screen")
    object ScoreBoard: Screen("scoreboard_screen")
    object AddOneByOneScore: Screen("add_one_by_one_score_screen")
}
