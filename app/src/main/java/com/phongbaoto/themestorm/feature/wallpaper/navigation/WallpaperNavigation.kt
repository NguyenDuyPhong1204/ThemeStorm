package com.phongbaoto.themestorm.feature.wallpaper.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.feature.wallpaper.WallpaperRoute
import com.phongbaoto.themestorm.feature.wallpaper.WallpaperUnlockRoute

const val WALL_PAPER_ROUTE = "WALL_PAPER_ROUTE"
const val UNLOCK_WALL_PAPER_ROUTE = "UNLOCK_WALL_PAPER_ROUTE"

fun NavController.navigateToWallpaperScreen(navOptions: NavOptions? = null) {
    navigate(WALL_PAPER_ROUTE, navOptions)
}

fun NavController.navigateToUnlockWallpaperScreen(navOptions: NavOptions? = null) {
    navigate(UNLOCK_WALL_PAPER_ROUTE, navOptions)
}

fun NavGraphBuilder.wallpaperScreen(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    composable(WALL_PAPER_ROUTE) {
        WallpaperRoute(
            onNavigateToMine = onNavigateToMine,
            onNavigateToCoin = onNavigateToCoin,
            onNavigateToSearch = onNavigateToSearch,
            onNavigateToDownload = onNavigateToDownload
        )
    }
}

fun NavGraphBuilder.unlockWallpaperScreen(
    onNavBack: () -> Unit
){
    composable(UNLOCK_WALL_PAPER_ROUTE){
        WallpaperUnlockRoute(
            onNavBack = onNavBack
        )
    }
}