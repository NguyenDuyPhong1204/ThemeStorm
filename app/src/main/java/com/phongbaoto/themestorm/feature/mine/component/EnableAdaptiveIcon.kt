package com.phongbaoto.themestorm.feature.mine.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.ui.SpaceRow

data class EnableAdaptiveIcon(
    val iconRes: Int,
    val textRes: Int,
)

@Composable
fun EnableAdaptiveIcon(
    enableAdaptiveIcon: Boolean,
    enableControl: Boolean,
    enableIconWaterMark: Boolean,
    onClickAdaptiveIcon: () -> Unit,
    onClickControl: () -> Unit,
    onClickIconWaterMark: () -> Unit
) {
    val listItemEnable = listOf(
        EnableAdaptiveIcon(R.drawable.ic_enable_control, R.string.enable_control),
        EnableAdaptiveIcon(R.drawable.ic_adaptive_icon, R.string.adaptive_control),
        EnableAdaptiveIcon(R.drawable.ic_icon_waternark, R.string.icon_watermark)
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
    ) {
        ItemEnable(
            enable = enableControl,
            item = listItemEnable[0],
            onChangeSwitch = onClickControl
        )
        ItemEnable(
            enable = enableAdaptiveIcon,
            item = listItemEnable[1],
            onChangeSwitch = onClickAdaptiveIcon
        )
        ItemEnable(
            enable = enableIconWaterMark,
            item = listItemEnable[2],
            onChangeSwitch = onClickIconWaterMark
        )
    }
}

@Composable
private fun ItemEnable(
    enable: Boolean,
    item: EnableAdaptiveIcon,
    onChangeSwitch: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(color = Color.Transparent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(item.iconRes),
                contentDescription = "enable item",
                modifier = Modifier
                    .size(25.dp)
            )
            SpaceRow(10.dp)
            Text(
                text = stringResource(item.textRes),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
        Switch(
            checked = enable,
            onCheckedChange = { onChangeSwitch() },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Color(0xFF45CE48)
            ),
            modifier = Modifier
                .scale(0.6f)
        )
    }
}