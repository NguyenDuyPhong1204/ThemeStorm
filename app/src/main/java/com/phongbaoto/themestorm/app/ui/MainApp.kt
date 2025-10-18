package com.phongbaoto.themestorm.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.phongbaoto.themestorm.app.helper.LocalAppState
import com.phongbaoto.themestorm.app.navigation.MainNavHost
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor
import com.phongbaoto.themestorm.core.theme.DefaultColorApp

@Composable
fun MainApp() {
    val appState = LocalAppState.current!!

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = DefaultBackGroundColor,
        bottomBar = {
            if (appState.currentTopLevelDestination != null) {
                MainNavigationBar()
            }
        }
    ) { innerPadding ->
        Box(
            Modifier
                .background(DefaultBackGroundColor)
                .then(
                    if (appState.currentTopLevelDestination != null) {
                        Modifier.padding(innerPadding)
                    } else Modifier
                )
        ) {
            MainNavHost()
        }
    }
}