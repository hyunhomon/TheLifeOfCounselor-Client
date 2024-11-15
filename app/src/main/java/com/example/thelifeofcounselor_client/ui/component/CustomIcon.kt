package com.example.thelifeofcounselor_client.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.thelifeofcounselor_client.R

object CustomIcons {
    val Back = R.drawable.ic_back
    val Close = R.drawable.ic_close
    val ArrowUpward = R.drawable.ic_arrow_upward
    val Visible = R.drawable.ic_visible
    val Invisible = R.drawable.ic_invisible
    val Clear = R.drawable.ic_clear
}

@Composable
fun CustomIcon(
    modifier: Modifier = Modifier,
    res: Int,
    description: String = "Custom Icon",
    size: Int,
    color: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier.size(size.dp),
        imageVector = ImageVector.vectorResource(id = res),
        contentDescription = description,
        tint = color
    )
}