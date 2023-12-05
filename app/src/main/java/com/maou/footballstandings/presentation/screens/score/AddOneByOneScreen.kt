package com.maou.footballstandings.presentation.screens.score

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.maou.footballstandings.model.ClubCompeting
import com.maou.footballstandings.model.ClubInfo
import com.maou.footballstandings.presentation.components.NameTextField
import com.maou.footballstandings.presentation.components.ScoreTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOneByOneScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ScoreViewModel,
    state: ScoreUiState,
    context: Context
) {

    if (state.message.isNotBlank()) {
        Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
    }

    var score1Text by remember {
        mutableStateOf("")
    }
    var name1 by remember { mutableStateOf("") }

    var score2Text by remember {
        mutableStateOf("")
    }
    var name2 by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Add one by one")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            NameTextField(
                onChange = { name1 = it },
                modifier = modifier,
                name = name1,
                label = "Club 1 Name"
            )
            ScoreTextField(
                onChange = { score1Text = it },
                scoreText = score1Text,
                scoreLabel = "Score Club 1"
            )

            NameTextField(
                onChange = { name2 = it },
                modifier = modifier,
                name = name2,
                label = "Club 2 Name"
            )
            ScoreTextField(
                onChange = { score2Text = it },
                scoreText = score2Text,
                scoreLabel = "Score Club 2"
            )

            ElevatedButton(onClick = {
                val pointClub1 = if (score1Text.toInt() > score2Text.toInt())
                    3
                else if (score1Text.toInt() == score2Text.toInt())
                    1
                else 0

                val pointClub2 = if (score2Text.toInt() > score1Text.toInt())
                    3
                else if (score2Text.toInt() == score1Text.toInt())
                    1
                else 0

                val club1 = ClubInfo(
                    name = name1,
                    city = name1,
                    point = pointClub1,
                    lose = if (pointClub1 < pointClub2) 1 else 0,
                    win = if (pointClub1 > pointClub2) 1 else 0,
                    draw = if (pointClub1 == pointClub2) 1 else 0,
                    playing = 1,
                    winGoal = score1Text.toInt(),
                    loseGoal = score2Text.toInt()
                )

                val club2 = ClubInfo(
                    name = name2,
                    city = name2,
                    point = pointClub2,
                    lose = if (pointClub2 < pointClub1) 1 else 0,
                    win = if (pointClub2 > pointClub1) 1 else 0,
                    draw = if (pointClub2 == pointClub1) 1 else 0,
                    playing = 1,
                    winGoal = score2Text.toInt(),
                    loseGoal = score1Text.toInt()
                )

                viewModel.processIntent(
                    ScoreIntent.OnUpdateClubScoreCompeting(
                        ClubCompeting(club1, club2)
                    )
                )

                if (state.message.isNotBlank()) {
                    Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                }

            }) {
                Text(text = "Save")
            }
        }
    }

}