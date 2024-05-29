package com.example.userapp.ui.presentations.composable

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.userapp.R

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) = if (LocalInspectionMode.current) {
    painterResource(id = debugPreview)
} else {
    null
}

@Preview(showBackground = true)
@Composable
fun DebugPlaceholderPreview() {
    debugPlaceholder(debugPreview = R.drawable.ic_launcher_foreground)
}