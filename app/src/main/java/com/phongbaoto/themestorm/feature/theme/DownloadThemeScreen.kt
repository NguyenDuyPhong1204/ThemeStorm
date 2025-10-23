package com.phongbaoto.themestorm.feature.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import com.phongbaoto.themestorm.core.ui.TopAppBarDownload

@Composable
fun DownloadThemeRoute(
    itemTheme: ItemTheme
) {
    DownloadThemeScreen(
        item = itemTheme
    )
}

@Composable
private fun DownloadThemeScreen(
    item: ItemTheme
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.demo_image_theme),
                contentDescription = "image demo",
                modifier = Modifier
                    .fillMaxSize()
                    .blur(5.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBarDownload(
                onNavBack = {}
            )
            SpaceColumn(10.dp)
            Image(
                painter = painterResource(R.drawable.demo_image_theme),
                contentDescription = "image demo",
                modifier = Modifier
                    .width(315.dp)
                    .height(570.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .zIndex(1f),
                contentScale = ContentScale.Crop
            )
            SpaceColumn(40.dp)
            Button(
                onClick = {},
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier
                    .size(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                contentPadding = PaddingValues(15.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_install),
                    contentDescription = "icon download",
                    modifier = Modifier
                        .size(25.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}