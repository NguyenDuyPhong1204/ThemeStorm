package com.phongbaoto.themestorm.feature.favorite.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.favorite.FavoriteRoute

const val FAVORITE_ROUTE = "FAVORITE_ROUTE"


fun NavController.navigateToFavoriteScreen(navOptions: NavOptions? = null) {
    navigate(FAVORITE_ROUTE, navOptions)
}

fun NavGraphBuilder.favoriteScreen() {
    composable(FAVORITE_ROUTE) {
        FavoriteRoute()
    }
}