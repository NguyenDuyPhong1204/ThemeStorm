package com.phongbaoto.themestorm.feature.mine.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.ui.SpaceColumn

@Composable
fun LimitTimeOffer(
    onClickGetPro: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFF6600),
                        Color(0xFFFB9654),
                        Color(0xFFF8909C),
                        Color(0xFFDA16DE)
                    )
                ),
                shape = RoundedCornerShape(15.dp)
            )
            .clickable(onClick = onClickGetPro)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = stringResource(R.string.limit_time_offer),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                SpaceColumn(10.dp)
                Text(
                    text = stringResource(R.string.all_content_no_ads),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Image(
                painter = painterResource(R.drawable.ic_crown),
                contentDescription = "icon crown",
                modifier = Modifier
                    .size(64.dp)
                    .rotate(45f)
            )
        }
    }
}