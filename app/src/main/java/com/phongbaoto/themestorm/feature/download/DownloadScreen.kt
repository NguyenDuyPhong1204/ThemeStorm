package com.phongbaoto.themestorm.feature.download

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor

@Composable
fun DownloadRoute() {
    DownloadScreen()
}

@Composable
private fun DownloadScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackGroundColor)
    ) {
        Text(
            text = "Download Screen",
            fontSize = 20.sp
        )
    }
}