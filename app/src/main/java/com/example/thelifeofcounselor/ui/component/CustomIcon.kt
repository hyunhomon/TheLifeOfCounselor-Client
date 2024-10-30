package com.example.thelifeofcounselor.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomIcon(
    modifier: Modifier = Modifier,
    res: Int,
    description: String,
    size: Int,
    color: Color = Color.Unspecified
) {
    Icon(
        imageVector = ImageVector.vectorResource(id = res),
        contentDescription = description,
        tint = color,
        modifier = modifier.size(size.dp)
    )
}