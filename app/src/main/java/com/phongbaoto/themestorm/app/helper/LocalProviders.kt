package com.phongbaoto.themestorm.app.helper

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import com.phongbaoto.themestorm.app.AppState
import com.phongbaoto.themestorm.app.AppViewModel

val LocalNavController = compositionLocalOf<NavHostController?> { null }
val LocalAppState = staticCompositionLocalOf<AppState?> { null }
val LocalAppViewModel = staticCompositionLocalOf<AppViewModel?> { null }