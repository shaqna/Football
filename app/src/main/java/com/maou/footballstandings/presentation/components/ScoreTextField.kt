package com.maou.footballstandings.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScoreTextField(
    modifier: Modifier = Modifier,
    onChange: (String) -> Unit,
    scoreText: String,
    scoreLabel: String,
) {
    OutlinedTextField(
        value = scoreText,
        onValueChange = onChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        label = {
            Text(text = scoreLabel)
        }
    )
}