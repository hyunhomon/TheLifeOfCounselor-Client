package com.example.thelifeofcounselor_client.ui.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier

fun Modifier.simpleClick(
    onClick: () -> Unit
): Modifier = clickable (
    onClick = onClick,
    indication = null,
    interactionSource = MutableInteractionSource()
)