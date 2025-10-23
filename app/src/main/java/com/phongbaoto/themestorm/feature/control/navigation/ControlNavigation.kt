package com.phongbaoto.themestorm.feature.control.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.feature.control.ControlRoute

const val CONTROL_ROUTE = "CONTROL_ROUTE"

fun NavController.navigateToControlScreen(navOptions: NavOptions?= null){
    navigate(CONTROL_ROUTE, navOptions)
}


fun NavGraphBuilder.controlScreen(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
){
    composable(CONTROL_ROUTE){
        ControlRoute(
            onNavigateToMine = onNavigateToMine,
            onNavigateToCoin = onNavigateToCoin,
            onNavigateToSearch = onNavigateToSearch,
            onNavigateToDownload = onNavigateToDownload
        )
    }
}