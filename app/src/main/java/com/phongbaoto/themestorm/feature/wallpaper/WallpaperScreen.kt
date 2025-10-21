package com.phongbaoto.themestorm.feature.wallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.TabItem
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor
import com.phongbaoto.themestorm.core.ui.HeaderApp
import com.phongbaoto.themestorm.core.ui.ScrollTabRow
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import com.phongbaoto.themestorm.feature.wallpaper.component.LiveStillComponent

@Composable
fun WallpaperRoute() {
    WallpaperScreen()
}

@Composable
private fun WallpaperScreen() {
    val tabListLive = listOf(
        TabItem(title = stringResource(R.string.new_text)),
        TabItem(title = stringResource(R.string.popular)),
        TabItem(title = stringResource(R.string.anime)),
        TabItem(title = stringResource(R.string.space), icon = R.drawable.ic_fire)
    )
    val tabListStill = listOf(
        TabItem(title = stringResource(R.string.new_text)),
        TabItem(title = stringResource(R.string.popular)),
        TabItem(title = stringResource(R.string.dark)),
        TabItem(title = stringResource(R.string.nature))
    )
    var selectedMode by remember { mutableIntStateOf(1) }
    val currentTabList = if (selectedMode == 0) tabListLive else tabListStill
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DefaultBackGroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp)
        ) {
            HeaderApp(
                title = stringResource(R.string.wall_paper),
                onClickMine = {},
                onClickCoin = {},
                onClickSearch = {}
            )
        }
        LiveStillComponent(
            selectedIndex = selectedMode,
            onSelect = {
                selectedMode = it
            }
        )
        SpaceColumn(20.dp)
        ScrollTabRow(
            listTab = currentTabList,
        )
    }
}