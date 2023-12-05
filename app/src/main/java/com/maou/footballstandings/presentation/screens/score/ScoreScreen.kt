package com.maou.footballstandings.presentation.screens.score

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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.maou.footballstandings.presentation.components.CityTextField
import com.maou.footballstandings.presentation.components.NameTextField
import com.maou.footballstandings.presentation.navigations.Screen
import com.maou.footballstandings.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Club")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Purple40
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            ElevatedButton(onClick = { navController.navigate(Screen.AddOneByOneScore.route) }) {
                Text(text = "Add one by one")
            }

            ElevatedButton(onClick = { /*TODO*/ }) {
                Text(text = "Add multiple")
            }
        }
    }
}