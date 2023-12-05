package com.maou.footballstandings.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maou.footballstandings.model.ClubInfo

@Composable
fun ClubInfoItem(
    clubInfo: ClubInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = modifier,
        ) {
            Text(
                text = "Club: ${clubInfo.name}",
            )
            Text(
                text = "Playing: ${clubInfo.playing}",
            )
            Text(
                text = "Win: ${clubInfo.win}",
            )
            Text(
                text = "Draw: ${clubInfo.draw}",
            )
            Text(
                text = "Lose: ${clubInfo.lose}",
            )
            Text(
                text = "WinGoal: ${clubInfo.winGoal}",
            )
            Text(
                text = "LoseGoal: ${clubInfo.loseGoal}",
            )

            Text(
                text = "Point: ${clubInfo.point}",
            )
        }
    }
}