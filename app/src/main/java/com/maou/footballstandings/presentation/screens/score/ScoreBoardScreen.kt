package com.maou.footballstandings.presentation.screens.score

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.maou.footballstandings.presentation.components.ClubInfoItem

@Composable
fun ScoreBoardScreen(
    context: Context,
    viewModel: ScoreViewModel,
    state: ClubsUiState
) {
    LaunchedEffect(key1 = true) {
        Log.d("MyEffect", "Launch effect happen")
        viewModel.processIntent(ScoreIntent.OnFetchClubsInfo)
    }

    LazyColumn(

    ) {
        items(items = state.list) { clubs ->
            ClubInfoItem(clubInfo = clubs)
        }
    }
}