package com.phongbaoto.themestorm.feature.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor

@Composable
fun FavoriteRoute(){
    FavoriteScreen()
}

@Composable
private fun FavoriteScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackGroundColor)
    ){
        Text(
            text = "Favorite Screen",
            fontSize = 20.sp
        )
    }
}