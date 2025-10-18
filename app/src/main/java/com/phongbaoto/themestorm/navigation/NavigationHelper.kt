package com.phongbaoto.themestorm.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

val NavController.sharedViewModel get() = SharedViewModel.instance
val NavGraphBuilder.sharedViewModel get() = SharedViewModel.instance
