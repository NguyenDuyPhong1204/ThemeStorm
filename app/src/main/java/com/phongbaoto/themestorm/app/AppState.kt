package com.phongbaoto.themestorm.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.phongbaoto.themestorm.app.navigation.TopLevelDestination
import com.phongbaoto.themestorm.feature.control.navigation.CONTROL_ROUTE
import com.phongbaoto.themestorm.feature.control.navigation.navigateToControlScreen
import com.phongbaoto.themestorm.feature.theme.navigation.THEME_ROUTE
import com.phongbaoto.themestorm.feature.theme.navigation.navigateToThemeScreen
import com.phongbaoto.themestorm.feature.wallpaper.navigation.WALL_PAPER_ROUTE
import com.phongbaoto.themestorm.feature.wallpaper.navigation.navigateToWallpaperScreen
import com.phongbaoto.themestorm.feature.widget.navigation.WIDGET_ROUTE
import com.phongbaoto.themestorm.feature.widget.navigation.navigateWidgetScreen

@Composable
fun rememberAppState(): AppState {
    val navController = rememberNavController()
    return AppState(navController)
}

class AppState(
    val navController: NavHostController
) {
    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() {
            val currentDestination = navController.currentBackStackEntryAsState().value?.destination
            return when (currentDestination?.route) {
                THEME_ROUTE -> TopLevelDestination.THEME
                WIDGET_ROUTE -> TopLevelDestination.WIDGET
                WALL_PAPER_ROUTE -> TopLevelDestination.WALL_PAPER
                CONTROL_ROUTE -> TopLevelDestination.CONTROL
                else -> null
            }
        }

    fun navigateToTopLevelDestination(destination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(THEME_ROUTE) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
        when (destination) {
            TopLevelDestination.THEME -> navController.navigateToThemeScreen(topLevelNavOptions)
            TopLevelDestination.WIDGET -> navController.navigateWidgetScreen(topLevelNavOptions)
            TopLevelDestination.WALL_PAPER -> navController.navigateToWallpaperScreen(
                topLevelNavOptions
            )

            TopLevelDestination.CONTROL -> navController.navigateToControlScreen(topLevelNavOptions)
        }
    }
}