package com.example.ibustartup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ibustartup.ui.theme.GrayStroke

@Composable
fun SmallCheckboxButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable { onCheckedChange(!checked) }
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(
                    color = if (checked) Color.Blue else GrayStroke,
                    shape = RoundedCornerShape(4.dp)
                )
        )
    }
}

@Composable
fun SmallCheckboxButtonDemo() {
    var checked by remember { mutableStateOf(false) }

    SmallCheckboxButton(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@Preview
@Composable
fun SmallCheckboxButtonPreview() {
    SmallCheckboxButtonDemo()
}
