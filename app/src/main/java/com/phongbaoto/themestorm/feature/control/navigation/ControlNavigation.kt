package com.phongbaoto.themestorm.feature.control.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.feature.control.ControlInstallRoute
import com.phongbaoto.themestorm.feature.control.ControlRoute
import com.phongbaoto.themestorm.feature.control.ControlUnlockRoute

const val CONTROL_ROUTE = "CONTROL_ROUTE"
const val CONTROL_UNLOCK_ROUTE = "CONTROL_UNLOCK_ROUTE"
const val CONTROL_INSTALL_ROUTE = "CONTROL_INSTALL_ROUTE"
fun NavController.navigateToControlScreen(navOptions: NavOptions?= null){
    navigate(CONTROL_ROUTE, navOptions)
}

fun NavController.navigateToControlUnlockScreen(navOptions: NavOptions?=null){
    navigate(CONTROL_UNLOCK_ROUTE, navOptions)
}

fun NavController.navigateToInstallScreen(navOptions: NavOptions?=null){
    navigate(CONTROL_INSTALL_ROUTE, navOptions)
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

fun NavGraphBuilder.controlUnlockScreen(
    onNavBack: () -> Unit
){
    composable(CONTROL_UNLOCK_ROUTE){
        ControlUnlockRoute(
            onNavBack = onNavBack
        )
    }
}
