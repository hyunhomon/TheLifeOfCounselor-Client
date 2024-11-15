package com.example.thelifeofcounselor_client.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.thelifeofcounselor_client.ui.util.simpleClick

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    isActivate: Boolean = true
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                MaterialTheme.shapes.medium
            )
            .then(
                if (isActivate) Modifier
                    .height(50.dp)
                    .simpleClick(onClick)
                else Modifier
                    .wrapContentHeight()
            )
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    if (isActivate) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
                    MaterialTheme.shapes.medium
                )
                .padding(12.dp),
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center
        )
    }
}