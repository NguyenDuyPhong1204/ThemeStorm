package com.phongbaoto.themestorm.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import com.phongbaoto.themestorm.app.helper.LocalAppState
import com.phongbaoto.themestorm.app.helper.LocalAppViewModel
import com.phongbaoto.themestorm.app.helper.LocalNavController
import com.phongbaoto.themestorm.app.ui.MainApp
import com.phongbaoto.themestorm.core.theme.ThemeStormTheme
import com.phongbaoto.themestorm.navigation.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val appViewModel: AppViewModel by viewModels()
    companion object {
        private const val IS_RESTORED_SESSION = "is_restored_session"
    }

    private val navigationViewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        SharedViewModel.setInstance(navigationViewModel)
        setContent {
            ThemeStormTheme {
                val appState = rememberAppState()
                CompositionLocalProvider(
                    LocalNavController provides appState.navController,
                    LocalAppState provides appState,
                    LocalAppViewModel provides appViewModel
                ) {
                    MainApp()
                }
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(IS_RESTORED_SESSION, true)
    }
}
