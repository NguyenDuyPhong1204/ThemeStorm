package com.phongbaoto.themestorm.feature.widget.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.widget.WidgetRoute

const val WIDGET_ROUTE = "WIDGET_ROUTE"

fun NavController.navigateWidgetScreen(navOptions: NavOptions? = null) {
    navigate(WIDGET_ROUTE, navOptions)
}

fun NavGraphBuilder.widgetScreen() {
    composable(WIDGET_ROUTE) {
        WidgetRoute()
    }
}