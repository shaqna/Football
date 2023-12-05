package com.maou.footballstandings.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameTextField(
    onChange: (String) -> Unit,
    modifier: Modifier,
    name: String,
    label: String
) {
    OutlinedTextField(
        value = name,
        onValueChange = onChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {
            Text(text = label)
        }
    )
}