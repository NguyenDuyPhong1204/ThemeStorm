package com.phongbaoto.themestorm.feature.wallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor

@Composable
fun WallpaperRoute() {
    WallpaperScreen()
}

@Composable
private fun WallpaperScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DefaultBackGroundColor)
    ) {
        Text("Wallpaper Screen")
    }
}