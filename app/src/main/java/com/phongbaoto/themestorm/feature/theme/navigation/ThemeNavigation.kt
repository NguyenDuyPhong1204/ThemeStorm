package com.phongbaoto.themestorm.feature.theme.navigation

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.feature.theme.DownloadThemeRoute
import com.phongbaoto.themestorm.feature.theme.ThemeRoute
import com.phongbaoto.themestorm.navigation.sharedViewModel

const val THEME_ROUTE = "THEME_ROUTE"
const val DOWNLOAD_THEME_ROUTE = "DOWNLOAD_THEME_ROUTE"

fun NavController.navigateToThemeScreen(navOptions: NavOptions? = null) {
    navigate(THEME_ROUTE, navOptions)
}

fun NavController.navigateToDownloadThemeScreen(item: ItemTheme, navOptions: NavOptions? = null) {
    sharedViewModel.put("item_theme", item, ItemTheme::class.java)
    navigate(DOWNLOAD_THEME_ROUTE, navOptions)
}

fun NavGraphBuilder.themeScreen(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    composable(THEME_ROUTE) {
        ThemeRoute(
            onNavigateToMine = onNavigateToMine,
            onNavigateToCoin = onNavigateToCoin,
            onNavigateToSearch = onNavigateToSearch,
            onNavigateToDownload = onNavigateToDownload
        )
    }
}

fun NavGraphBuilder.downloadThemeScreen() {
    composable(DOWNLOAD_THEME_ROUTE) {
        val item = remember { sharedViewModel.get("item_theme", ItemTheme::class.java) }
        item?.let {
            DownloadThemeRoute(
                itemTheme = it
            )
        }
    }
}