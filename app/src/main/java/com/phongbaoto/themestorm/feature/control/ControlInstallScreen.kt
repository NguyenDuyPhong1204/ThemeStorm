package com.phongbaoto.themestorm.feature.control

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.core.theme.DefaultColorApp
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import com.phongbaoto.themestorm.core.ui.TopAppBarDownload
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ControlInstallRoute(
    itemTheme: ItemTheme,
    onNavBack: () -> Unit,
    onNavigateToInstallTheme: () -> Unit
){
    ControlInstallScreen(
        item = itemTheme,
        onNavBack = onNavBack,
        onNavigateToInstallTheme = onNavigateToInstallTheme,
        onClickInfo = {},
        onClickFavorite = {}
    )
}

@Composable
private fun ControlInstallScreen(
    item: ItemTheme,
    onNavBack: () -> Unit,
    onNavigateToInstallTheme: () -> Unit,
    onClickInfo: () -> Unit,
    onClickFavorite: () -> Unit,
){
    var downloadProgress by remember { mutableIntStateOf(0) }
    var isDownloading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(downloadProgress) {
        if (downloadProgress >= 100) {
            delay(500)
            onNavigateToInstallTheme()
        }
    }

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
                painter = painterResource(item.imageRes),
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

        }
    }
}