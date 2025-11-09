package com.phongbaoto.themestorm.feature.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.core.model.TabItem
import com.phongbaoto.themestorm.core.model.listNew
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor
import com.phongbaoto.themestorm.core.ui.HeaderApp
import com.phongbaoto.themestorm.core.ui.ScrollTabRow
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import com.phongbaoto.themestorm.feature.widget.component.WidgetBottomSheet

@Composable
fun WidgetRoute(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    WidgetScreen(
        onNavigateToMine = onNavigateToMine,
        onNavigateToCoin = onNavigateToCoin,
        onNavigateToSearch = onNavigateToSearch,
        onNavigateToDownload = onNavigateToDownload
    )
}

@Composable
private fun WidgetScreen(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    val tabList = listOf(
        TabItem(title = stringResource(R.string.new_text), listTheme = listNew),
        TabItem(title = stringResource(R.string.gif), listTheme = listNew),
        TabItem(title = stringResource(R.string.music), listTheme = listNew),
        TabItem(
            title = stringResource(R.string.time),
            icon = R.drawable.ic_fire,
            listTheme = listNew
        )
    )
    var isShowSheet by remember { mutableStateOf(false) }
    var selectedWidget by remember { mutableStateOf<ItemTheme?>(null) }
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
                onClickMine = onNavigateToMine,
                onClickCoin = onNavigateToCoin,
                onClickSearch = onNavigateToSearch
            )
        }
        SpaceColumn(10.dp)
        ScrollTabRow(
            listTab = tabList,
            isGridLayout = false,
            onClickItem = {
                selectedWidget = it
                isShowSheet = true
            }
        )

        selectedWidget?.let {
            WidgetBottomSheet(
                item = it,
                isShowSheet = isShowSheet,
                onDismiss = {
                    isShowSheet = false
                },
                onClose = {
                    isShowSheet = false
                },
                onClickInfo = {},
                onDownload = {
                    isShowSheet = false
                    onNavigateToDownload(it)
                },
                onClickFavorite = {}
            )
        }
    }
}