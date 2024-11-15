package com.example.thelifeofcounselor_client.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thelifeofcounselor_client.ui.util.simpleClick

@Composable
fun PageDescription(
    onClickBack: (() -> Unit)? = null,
    title: String,
    description: String
) {
    Column {
        if (onClickBack != null) {
            CustomIcon(
                modifier = Modifier.simpleClick(onClickBack),
                res = CustomIcons.Back,
                size = 28,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacing(vertical = if (onClickBack != null) 12 else 24)
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacing(vertical = 12)
        Text(
            text = description,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacing(vertical = if (onClickBack != null) 40 else 48)
    }
}