package com.phongbaoto.themestorm.feature.wallpaper

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import com.phongbaoto.themestorm.core.ui.TopAppBarDownload

@Composable
fun WallpaperUnlockRoute(
    onNavBack: () -> Unit,
) {
    WallpaperUnlockScreen(
        onNavBack = onNavBack,
        onGetAll = {},
        onUnlock = {},
        onClickInfo = {},
        onClickFavorite = {}
    )
}

@Composable
private fun WallpaperUnlockScreen(
    onNavBack: () -> Unit,
    onGetAll: () -> Unit,
    onUnlock: () -> Unit,
    onClickInfo: () -> Unit,
    onClickFavorite: () -> Unit,
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
                onNavBack = onNavBack,
                onClickInfo = onClickInfo,
                onClickFavorite = onClickFavorite
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
            Row(
                modifier = Modifier
                    .width(315.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                    .clickable(onClick = onGetAll)
                        .width(102.dp)
                        .height(48.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFFF6600),
                                    Color(0xFFFB9654),
                                    Color(0xFFF8909C),
                                    Color(0xFFDA16DE)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.get_all),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                    .clickable(onClick = onUnlock)
                        .width(178.dp)
                        .height(48.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFFD134F8),
                                    Color(0xFF9939F2),
                                    Color(0xFF6B79F3),
                                    Color(0xFF457CF3)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.unlock_with),
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = " 500 ",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_coin),
                            contentDescription = "image coin",
                            modifier = Modifier
                                .size(15.dp),
                        )
                    }
                }
            }
        }
    }
}