package com.phongbaoto.themestorm.feature.widget.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.feature.widget.WidgetRoute

const val WIDGET_ROUTE = "WIDGET_ROUTE"

fun NavController.navigateWidgetScreen(navOptions: NavOptions? = null) {
    navigate(WIDGET_ROUTE, navOptions)
}

fun NavGraphBuilder.widgetScreen(
    onNavigateToMine: () -> Unit,
    onNavigateToCoin: () -> Unit,
    onNavigateToSearch: () -> Unit,
    onNavigateToDownload: (ItemTheme) -> Unit
) {
    composable(WIDGET_ROUTE) {
        WidgetRoute(
            onNavigateToMine = onNavigateToMine,
            onNavigateToCoin = onNavigateToCoin,
            onNavigateToSearch = onNavigateToSearch,
            onNavigateToDownload = onNavigateToDownload
        )
    }
}