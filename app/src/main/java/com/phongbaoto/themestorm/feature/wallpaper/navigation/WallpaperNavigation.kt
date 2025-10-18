package com.phongbaoto.themestorm.feature.wallpaper.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.wallpaper.WallpaperRoute

const val WALL_PAPER_ROUTE = "WALL_PAPER_ROUTE"

fun NavController.navigateToWallpaperScreen(navOptions: NavOptions?= null){
    navigate(WALL_PAPER_ROUTE, navOptions)
}

fun NavGraphBuilder.wallpaperScreen(){
    composable(WALL_PAPER_ROUTE){
        WallpaperRoute()
    }
}