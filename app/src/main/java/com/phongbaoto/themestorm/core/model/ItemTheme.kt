package com.phongbaoto.themestorm.core.model

import com.phongbaoto.themestorm.R
import kotlinx.serialization.Serializable

@Serializable
data class ItemTheme(
    val imageRes: Int
)

@Serializable
data class IconThem(
    val id: Int,
    val imageRes: Int
)

val listTestIconTheme = listOf(
    IconThem(
        1,
        R.drawable.chrome_raiden
    ),
    IconThem(
        2,
        R.drawable.chrome_raiden
    ),
    IconThem(
        3,
        R.drawable.chrome_raiden
    ),
    IconThem(
        4,
        R.drawable.chrome_raiden
    ),
    IconThem(
        5,
        R.drawable.chrome_raiden
    ),
)

val listNew = listOf(
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
)
val listEditorPick= listOf(
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
)
val listThemePack= listOf(
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
)
val listPopular= listOf(
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
    ItemTheme(
        imageRes = R.drawable.demo_image_theme
    ),
)