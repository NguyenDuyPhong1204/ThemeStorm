package com.phongbaoto.themestorm.feature.download.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.download.DownloadRoute

const val DOWNLOAD_ROUTE = "DOWNLOAD_ROUTE"


fun NavController.navigateToDownloadScreen(navOptions: NavOptions? = null) {
    navigate(DOWNLOAD_ROUTE, navOptions)
}

fun NavGraphBuilder.downloadScreen() {
    composable(DOWNLOAD_ROUTE) {
        DownloadRoute()
    }
}