package com.example.thelifeofcounselor_client.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thelifeofcounselor_client.ui.util.simpleClick

@Composable
fun ProgressBarWithClose(
    modifier: Modifier = Modifier,
    currentProgress: Int,
    maxProgress: Int,
    onClose: () -> Unit
) {
    val progressFraction = (currentProgress.toFloat() / maxProgress).coerceIn(0f, 1f)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIcon(
            modifier = Modifier.simpleClick(onClose),
            res = CustomIcons.Close,
            size = 28,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacing(horizontal = 12)
        Box(
            modifier = Modifier
                .weight(1f)
                .height(16.dp)
                .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.medium)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(progressFraction)
                    .fillMaxHeight()
                    .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.medium)
            )
        }
    }
}