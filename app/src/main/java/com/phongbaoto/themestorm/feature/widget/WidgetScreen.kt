package com.phongbaoto.themestorm.feature.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
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

@Composable
fun WidgetRoute() {
    WidgetScreen()
}

@Composable
private fun WidgetScreen() {
    val tabList = listOf(
        TabItem(title = stringResource(R.string.new_text)),
        TabItem(title = stringResource(R.string.gif)),
        TabItem(title = stringResource(R.string.music)),
        TabItem(title = stringResource(R.string.time), icon = R.drawable.ic_fire)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DefaultBackGroundColor)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp)
        ) {
            HeaderApp(
                title = stringResource(R.string.widget),
                onClickMine = {},
                onClickCoin = {},
                onClickSearch = {}
            )
        }
        SpaceColumn(10.dp)
        ScrollTabRow(
            listTab = tabList,
            isGridLayout = false
        )
    }
}