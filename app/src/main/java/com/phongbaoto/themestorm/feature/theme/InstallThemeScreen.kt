package com.phongbaoto.themestorm.feature.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.IconThem
import com.phongbaoto.themestorm.core.model.listTestIconTheme
import com.phongbaoto.themestorm.feature.theme.component.ItemChangeTheme
import com.phongbaoto.themestorm.feature.theme.component.TopAppBarInstall

@Preview
@Composable
private fun PreviewInstall() {
    InstallThemeScreen()
}

@Composable
fun InstallThemeRoute(
    onNavBack: () -> Unit,
//    onClickQuestion: () -> Unit,
//    onClickCoin: () -> Unit
) {
    InstallThemeScreen(
        onNavBack = onNavBack,
        onClickQuestion = {},
        onClickCoin = {}
    )
}

@Composable
private fun InstallThemeScreen(
    onNavBack: () -> Unit = {},
    onClickQuestion: () -> Unit = {},
    onClickCoin: () -> Unit = {}
) {
    var selectedIcon by remember { mutableStateOf<IconThem?>(null) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopAppBarInstall(
            title = stringResource(R.string.install_theme),
            onNavBack = onNavBack,
            onClickQuestion = onClickQuestion,
            onClickCoin = onClickCoin
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(listTestIconTheme) { item ->
                ItemChangeTheme(
                    itemTheme = item,
                    isSelected = item == selectedIcon,
                    onClickItem = {
                        selectedIcon = item
                    },
                    onUnlockIconTheme = {

                    },
                    onClickChangeIcon = {}
                )
                VerticalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color(0xFFC1BFBF)
                )
            }
        }

    }
}