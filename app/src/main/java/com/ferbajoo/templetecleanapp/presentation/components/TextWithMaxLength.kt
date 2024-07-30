package com.ferbajoo.templetecleanapp.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TextWithMaxLength(text: String, maxLength: Int) {
    val truncatedText = if (text.length > maxLength) {
        text.substring(0, maxLength) + "..."
    } else {
        text
    }

    Text(text = truncatedText, color = MaterialTheme.colorScheme.onPrimary)
}