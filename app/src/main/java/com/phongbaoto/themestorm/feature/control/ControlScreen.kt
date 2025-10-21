package com.phongbaoto.themestorm.feature.control

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
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
fun ControlRoute() {
    ControlScreen()
}

@Composable
private fun ControlScreen() {
    val tabList = listOf(
        TabItem(title = stringResource(R.string.new_text)),
        TabItem(title = stringResource(R.string.popular)),
        TabItem(title = stringResource(R.string.cute)),
        TabItem(title = stringResource(R.string.anime))
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
                title = stringResource(R.string.control),
                onClickMine = {},
                onClickCoin = {},
                onClickSearch = {}
            )
        }
        SpaceColumn(10.dp)
        ScrollTabRow(
            listTab = tabList,
            isGridLayout = true
        )
    }
}