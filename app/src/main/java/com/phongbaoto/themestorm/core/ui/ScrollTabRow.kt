package com.phongbaoto.themestorm.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.TabItem

@Preview
@Composable
private fun PreviewScrollTabRow(){
    ScrollTabRow()
}

@Composable
fun ScrollTabRow(){
    val tabList = listOf(
        TabItem(title = stringResource(R.string.new_text), icon = R.drawable.ic_new),
        TabItem(title = stringResource(R.string.editors_pick), icon = R.drawable.ic_edit),
        TabItem(title = stringResource(R.string.theme_pack), icon = R.drawable.ic_star),
        TabItem(title = stringResource(R.string.popular), icon = R.drawable.ic_fire)
    )
}