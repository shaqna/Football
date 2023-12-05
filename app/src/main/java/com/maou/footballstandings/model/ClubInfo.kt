package com.maou.footballstandings.model

data class ClubInfo(
    val name: String = "",
    val city: String = "",
    val playing: Int = 0,
    val win: Int = 0,
    val draw: Int = 0,
    val lose: Int = 0,
    val winGoal: Int = 0,
    val loseGoal: Int = 0,
    val point: Int = 0
)
