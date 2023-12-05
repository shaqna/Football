package com.maou.footballstandings.presentation.screens.club

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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.maou.footballstandings.model.ClubInfo
import com.maou.footballstandings.presentation.components.CityTextField
import com.maou.footballstandings.presentation.components.NameTextField
import com.maou.footballstandings.presentation.navigations.Screen
import com.maou.footballstandings.ui.theme.Purple40
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClubScreen(
    context: Context,
    modifier: Modifier = Modifier,
    navController: NavController,
    clubViewModel: ClubViewModel,
    state: ClubUiState
) {


    if(state.message.isNotBlank()) {
        Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
    }

    var name by remember {
        mutableStateOf("")
    }

    var city by remember { mutableStateOf("") }


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
            NameTextField(
                onChange = { name = it },
                modifier = modifier,
                name = name,
                label = "Club Name"
            )

            CityTextField(
                onChange = { city = it },
                city = city,
                label = "City",
                modifier = modifier
            )

            ElevatedButton(onClick = {
                val clubInfo = ClubInfo(
                    name = name,
                    city = city,

                )
                clubViewModel.processIntent(ClubIntent.OnSaveClubInfo(clubInfo))

                if(state.message.isNotBlank()) {
                    Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Save")
            }
        }
    }


}