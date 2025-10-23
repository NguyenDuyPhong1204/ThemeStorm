package com.phongbaoto.themestorm.feature.theme

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
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.core.model.TabItem
import com.phongbaoto.themestorm.core.model.listEditorPick
import com.phongbaoto.themestorm.core.model.listNew
import com.phongbaoto.themestorm.core.model.listPopular
import com.phongbaoto.themestorm.core.model.listThemePack
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor
import com.phongbaoto.themestorm.core.ui.HeaderApp
import com.phongbaoto.themestorm.core.ui.ScrollTabRow
import com.phongbaoto.themestorm.core.ui.SpaceColumn

@Composable
fun ThemeRoute(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    ThemeScreen(
        onNavigateToMine = onNavigateToMine,
        onNavigateToCoin = onNavigateToCoin,
        onNavigateToSearch = onNavigateToSearch,
        onNavigateToDownload = onNavigateToDownload
    )
}

@Composable
private fun ThemeScreen(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    val tabList = listOf(
        TabItem(title = stringResource(R.string.new_text), icon = R.drawable.ic_new, listTheme = listNew),
        TabItem(title = stringResource(R.string.editors_pick), icon = R.drawable.ic_edit, listTheme = listEditorPick),
        TabItem(title = stringResource(R.string.theme_pack), icon = R.drawable.ic_star, listTheme = listThemePack),
        TabItem(title = stringResource(R.string.popular), icon = R.drawable.ic_fire, listTheme = listPopular)
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
                title = stringResource(R.string.theme),
                onClickMine = onNavigateToMine,
                onClickCoin = onNavigateToCoin,
                onClickSearch = onNavigateToSearch
            )
        }
        SpaceColumn(10.dp)
        ScrollTabRow(
            listTab = tabList,
            isGridLayout = true,
            onClickItem = onNavigateToDownload
        )
    }
}