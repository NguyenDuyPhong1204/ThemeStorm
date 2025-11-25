package com.phongbaoto.themestorm.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.phongbaoto.themestorm.feature.search.SearchRoute

const val SEARCH_ROUTE = "SEARCH_ROUTE"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    navigate(SEARCH_ROUTE, navOptions)
}

fun NavGraphBuilder.searchScreen(){
    composable(SEARCH_ROUTE){
        SearchRoute()
    }
}