package com.phongbaoto.themestorm.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import com.phongbaoto.themestorm.app.helper.LocalAppViewModel
import com.phongbaoto.themestorm.app.helper.LocalNavController
import com.phongbaoto.themestorm.feature.control.navigation.controlScreen
import com.phongbaoto.themestorm.feature.download.navigation.downloadScreen
import com.phongbaoto.themestorm.feature.download.navigation.navigateToDownloadScreen
import com.phongbaoto.themestorm.feature.favorite.navigation.favoriteScreen
import com.phongbaoto.themestorm.feature.favorite.navigation.navigateToFavoriteScreen
import com.phongbaoto.themestorm.feature.mine.navigation.mineScreen
import com.phongbaoto.themestorm.feature.mine.navigation.navigateToMineScreen
import com.phongbaoto.themestorm.feature.theme.navigation.THEME_ROUTE
import com.phongbaoto.themestorm.feature.theme.navigation.downloadThemeScreen
import com.phongbaoto.themestorm.feature.theme.navigation.installThemeScreen
import com.phongbaoto.themestorm.feature.theme.navigation.navigateToDownloadThemeScreen
import com.phongbaoto.themestorm.feature.theme.navigation.navigateToInstallThemeScreen
import com.phongbaoto.themestorm.feature.theme.navigation.themeScreen
import com.phongbaoto.themestorm.feature.wallpaper.navigation.wallpaperScreen
import com.phongbaoto.themestorm.feature.widget.navigation.widgetScreen

@Composable
fun MainNavHost() {
    val navController = LocalNavController.current!!
    val appViewMode = LocalAppViewModel.current!!
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = THEME_ROUTE
    ) {
        themeScreen(
            onNavigateToMine = {
                navController.navigateToMineScreen()
            },
            onNavigateToCoin = {},
            onNavigateToSearch = {},
            onNavigateToDownload = {
                navController.navigateToDownloadThemeScreen(it)
            }
        )
        downloadThemeScreen(
            onNavBack = {
                navController.popBackStack()
            },
            onNavigateToInstallTheme = {
                navController.navigateToInstallThemeScreen()
            }
        )
        installThemeScreen(
            onNavBack = {
                navController.popBackStack()
            }
        )
        widgetScreen(
            onNavigateToMine = {
                navController.navigateToMineScreen()
            },
            onNavigateToCoin = {},
            onNavigateToSearch = {},
            onNavigateToDownload = {}
        )
        wallpaperScreen(
            onNavigateToMine = {
                navController.navigateToMineScreen()
            },
            onNavigateToCoin = {},
            onNavigateToSearch = {},
            onNavigateToDownload = {}
        )
        controlScreen(
            onNavigateToMine = {
                navController.navigateToMineScreen()
            },
            onNavigateToCoin = {},
            onNavigateToSearch = {},
            onNavigateToDownload = {}
        )
        mineScreen(
            onNavBack = {
                navController.popBackStack()
            },
            onNavigateToFavorite = {
                navController.navigateToFavoriteScreen()
            },
            onNavigateToDownload = {
                navController.navigateToDownloadScreen()
            }
        )
        favoriteScreen()
        downloadScreen()
    }
}