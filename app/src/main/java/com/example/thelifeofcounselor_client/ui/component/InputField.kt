package com.example.thelifeofcounselor_client.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.thelifeofcounselor_client.ui.util.simpleClick

@Composable
fun InputField(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    isPasswordActivate: Boolean = true
) {
    var passwordVisible = remember { mutableStateOf(!isPasswordActivate) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.medium)
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.medium),
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onBackground
        )
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.weight(1f)) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                innerTextField()
            }
            Spacing(horizontal = 8)
            if (isPasswordActivate || (!isPasswordActivate && value.isNotEmpty())) {
                CustomIcon(
                    modifier = Modifier.simpleClick(
                        onClick = {
                            if (isPasswordActivate)
                                passwordVisible.value = !passwordVisible.value
                            else
                                onValueChange("")
                        }
                    ),
                    res = if (!isPasswordActivate) CustomIcons.Clear else {
                        if (passwordVisible.value) CustomIcons.Visible
                        else CustomIcons.Invisible
                    },
                    size = 24,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun InputFieldWithBtn(
    modifier: Modifier = Modifier,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    onClickBtn: () -> Unit,
    singleLine: Boolean = true,
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.medium)
            .border(1.dp, MaterialTheme.colorScheme.outline, MaterialTheme.shapes.medium),
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
        textStyle = MaterialTheme.typography.bodyLarge.copy(
            color = MaterialTheme.colorScheme.onBackground
        )
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp, 8.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.weight(1f))
            {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                innerTextField()
            }
            Spacing(horizontal = 8)
            Box(
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        MaterialTheme.shapes.small
                    )
                    .simpleClick(onClickBtn)
            ) {
                CustomIcon(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary, MaterialTheme.shapes.small)
                        .padding(10.dp, 8.dp),
                    res = CustomIcons.ArrowUpward,
                    size = 20,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}