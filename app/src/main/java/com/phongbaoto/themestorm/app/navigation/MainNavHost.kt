package com.phongbaoto.themestorm.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import com.phongbaoto.themestorm.app.helper.LocalAppViewModel
import com.phongbaoto.themestorm.app.helper.LocalNavController
import com.phongbaoto.themestorm.feature.control.navigation.controlScreen
import com.phongbaoto.themestorm.feature.mine.navigation.mineScreen
import com.phongbaoto.themestorm.feature.theme.navigation.THEME_ROUTE
import com.phongbaoto.themestorm.feature.theme.navigation.themeScreen
import com.phongbaoto.themestorm.feature.wallpaper.navigation.wallpaperScreen
import com.phongbaoto.themestorm.feature.widget.navigation.widgetScreen

@Composable
fun MainNavHost(){
    val navController = LocalNavController.current!!
    val appViewMode = LocalAppViewModel.current!!
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = THEME_ROUTE
    ){
        themeScreen()
        widgetScreen()
        wallpaperScreen()
        controlScreen()
        mineScreen()
    }
}