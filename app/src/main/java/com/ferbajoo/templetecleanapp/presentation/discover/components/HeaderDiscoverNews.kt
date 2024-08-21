package com.ferbajoo.templetecleanapp.presentation.discover.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderDiscoverNews() {
    Column(modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Discover",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onTertiary,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "News from all around the world",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onTertiary,
        )
    }
}