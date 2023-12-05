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
fun CityTextField(
    onChange: (String) -> Unit,
    city: String,
    label: String,
    modifier: Modifier,
) {
    OutlinedTextField(
        value = city,
        onValueChange = onChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = {
            Text(text = label)
        })
}