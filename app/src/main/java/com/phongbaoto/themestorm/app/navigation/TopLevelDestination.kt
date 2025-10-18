package com.phongbaoto.themestorm.app.navigation

import androidx.compose.ui.graphics.Color
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.theme.DefaultColorApp
import com.phongbaoto.themestorm.core.theme.GrayColor

enum class TopLevelDestination(
    val label:  Int,
    val icon: Int,
    val selectedColor: Color,
    val unselectedColor: Color
){
    THEME(
        label = R.string.theme,
        icon = R.drawable.ic_home,
        selectedColor = DefaultColorApp,
        unselectedColor = GrayColor
    ),
    WIDGET(
        label = R.string.widget,
        icon = R.drawable.ic_widget,
        selectedColor = DefaultColorApp,
        unselectedColor = GrayColor
    ),
    WALL_PAPER(
        label = R.string.wall_paper,
        icon = R.drawable.ic_wallpaper,
        selectedColor = DefaultColorApp,
        unselectedColor = GrayColor
    ),
    CONTROL(
        label = R.string.control,
        icon = R.drawable.ic_control,
        selectedColor = DefaultColorApp,
        unselectedColor = GrayColor
    )
}