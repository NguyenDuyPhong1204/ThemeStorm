package com.phongbaoto.themestorm.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.phongbaoto.themestorm.app.helper.LocalAppState
import com.phongbaoto.themestorm.app.helper.LocalAppViewModel
import com.phongbaoto.themestorm.app.navigation.TopLevelDestination
import com.phongbaoto.themestorm.core.theme.DefaultColorApp
import com.phongbaoto.themestorm.core.theme.GrayColor

@Composable
fun MainNavigationBar() {
    val destinations = TopLevelDestination.entries.toList()
    val appState = LocalAppState.current!!
    val appViewModel = LocalAppViewModel.current!!
    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        containerColor = Color.White,
        tonalElevation = 3.dp
    ) {
        destinations.forEach { destination ->
            with(destination) {
                val selected = appState.currentTopLevelDestination == destination
                NavigationBarItem(
                    label = {
                        Text(
                            text = stringResource(label),
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            appState.navigateToTopLevelDestination(destination)
                        }
                    },
                    icon = {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp),
                                tint = if (selected) selectedColor else unselectedColor,
                                painter = painterResource(id = icon),
                                contentDescription = null,
                            )
                        }

                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                        selectedTextColor = DefaultColorApp,
                        unselectedTextColor = GrayColor,
                    )
                )
            }
        }
    }
}