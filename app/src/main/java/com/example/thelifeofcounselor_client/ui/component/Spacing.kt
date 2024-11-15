package com.example.thelifeofcounselor_client.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Spacing(
    modifier: Modifier = Modifier,
    horizontal: Int = 0,
    vertical: Int = 0
) {
    Spacer(modifier = modifier
        .width(horizontal.dp).height(vertical.dp))
}