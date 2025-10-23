package com.phongbaoto.themestorm.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.phongbaoto.themestorm.core.model.ItemTheme

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    height: Dp = 400.dp,
    item: ItemTheme,
    onClickItem: () -> Unit
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClickItem)
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Image(
            painter = painterResource(item.imageRes),
            contentDescription = "image preview theme",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}