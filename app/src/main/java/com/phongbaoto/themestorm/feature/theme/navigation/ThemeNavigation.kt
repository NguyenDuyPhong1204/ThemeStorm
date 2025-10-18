package com.phongbaoto.themestorm.feature.theme.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.theme.ThemeRoute

const val THEME_ROUTE = "THEME_ROUTE"

fun NavController.navigateToThemeScreen(navOptions: NavOptions?= null){
    navigate(THEME_ROUTE, navOptions)
}

fun NavGraphBuilder.themeScreen(){
    composable(THEME_ROUTE){
        ThemeRoute()
    }
}