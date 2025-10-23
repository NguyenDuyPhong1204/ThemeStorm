package com.phongbaoto.themestorm.feature.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor
import com.phongbaoto.themestorm.core.theme.DefaultLineColor
import com.phongbaoto.themestorm.core.ui.HeaderBack
import com.phongbaoto.themestorm.core.ui.RowMineItem
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import com.phongbaoto.themestorm.core.ui.SpaceRow
import com.phongbaoto.themestorm.feature.mine.component.EnableAdaptiveIcon
import com.phongbaoto.themestorm.feature.mine.component.LimitTimeOffer
@Composable
fun MineRoute(
    onNavBack: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToDownload: () -> Unit
) {
    MineScreen(
        onNavBack = onNavBack,
        onNavigateToFavorite = onNavigateToFavorite,
        onNavigateToDownload = onNavigateToDownload
    )
}

@Composable
private fun MineScreen(
    onNavBack: () -> Unit,
    onNavigateToFavorite: () -> Unit,
    onNavigateToDownload: () -> Unit
) {
    var enableControl by remember { mutableStateOf(false) }
    var enableAdaptiveIcon by remember { mutableStateOf(false) }
    var enableIconWaterMark by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DefaultBackGroundColor)
            .padding(horizontal = 16.dp)
    ) {
        HeaderBack(
            title = stringResource(R.string.mine),
            onNavBack = onNavBack
        )
        SpaceColumn(10.dp)
        LimitTimeOffer(
            onClickGetPro = {}
        )
        SpaceColumn(20.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            //favorite
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .width(140.dp)
                    .height(55.dp)
                    .clickable(onClick = onNavigateToFavorite)
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCFCFCF),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_favorite),
                    contentDescription = "icon favorite",
                    modifier = Modifier
                        .size(30.dp)
                )
                SpaceRow(10.dp)
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = stringResource(R.string.favorite),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Text(
                        text = 0.toString(),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                }
            }
            //download
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
                    .width(140.dp)
                    .height(55.dp)
                    .clickable(onClick = onNavigateToDownload)
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFFCFCFCF),
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(vertical = 5.dp, horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_dowload_2),
                    contentDescription = "icon download",
                    modifier = Modifier
                        .size(30.dp)
                )
                SpaceRow(10.dp)
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = stringResource(R.string.download),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                    Text(
                        text = 0.toString(),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                }
            }
        }
        //
        SpaceColumn(20.dp)
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = DefaultLineColor
        )
        //
        EnableAdaptiveIcon(
            enableAdaptiveIcon = enableAdaptiveIcon,
            enableControl = enableControl,
            enableIconWaterMark = enableIconWaterMark,
            onClickControl = {
                enableControl = !enableControl
            },
            onClickAdaptiveIcon = {
                enableAdaptiveIcon = !enableAdaptiveIcon
            },
            onClickIconWaterMark = {
                enableIconWaterMark = !enableIconWaterMark
            }
        )
        ////sub and how to use
        SpaceColumn(20.dp)
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = DefaultLineColor
        )
        //sub and how to use
        SpaceColumn(20.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RowMineItem(
                iconRes = R.drawable.ic_subcription_management,
                textRes = R.string.subcription_management,
                onClickItem = {}
            )
            RowMineItem(
                iconRes = R.drawable.ic_how_to_use,
                textRes = R.string.how_to_use,
                onClickItem = {}
            )
        }
        //other
        SpaceColumn(20.dp)
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = DefaultLineColor
        )
        //other
        SpaceColumn(20.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            RowMineItem(
                iconRes = R.drawable.ic_rate_us,
                textRes = R.string.rate_us,
                onClickItem = {}
            )
            RowMineItem(
                iconRes = R.drawable.ic_contact_us,
                textRes = R.string.contact_us,
                onClickItem = {}
            )
            RowMineItem(
                iconRes = R.drawable.ic_privacy_policy,
                textRes = R.string.privacy_policy,
                onClickItem = {}
            )
        }
    }
}