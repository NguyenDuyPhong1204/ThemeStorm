package com.phongbaoto.themestorm.feature.mine.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.mine.MineRoute

const val MINE_ROUTE = "MINE_ROUTE"

fun NavController.navigateToMineScreen(navOptions: NavOptions? = null) {
    navigate(MINE_ROUTE, navOptions)
}

fun NavGraphBuilder.mineScreen() {
    composable(MINE_ROUTE) {
        MineRoute()
    }
}