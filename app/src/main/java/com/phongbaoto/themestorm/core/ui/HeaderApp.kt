package com.phongbaoto.themestorm.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.theme.DefaultColorApp

@Preview
@Composable
private fun PreviewHeaderApp() {
    HeaderApp(
        title = "Themes",
        {},
        {},
        {}
    )
}

@Composable
fun HeaderApp(
    title: String,
    onClickMine: () -> Unit,
    onClickCoin: () -> Unit,
    onClickSearch: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .width(120.dp),
        ) {
            Button(
                onClick = onClickMine,
                modifier = Modifier
                    .width(67.dp)
                    .height(26.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(1.dp),
                contentPadding = PaddingValues(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_mine),
                        contentDescription = "icon mine",
                        modifier = Modifier
                            .size(15.dp),
                        tint = DefaultColorApp
                    )
                    Text(
                        text = stringResource(R.string.mine),
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Light,
                            lineHeight = 15.sp
                        ),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
            Spacer(Modifier.width(20.dp))
            Button(
                onClick = onClickSearch,
                modifier = Modifier
                    .size(26.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(100.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(1.dp),
                contentPadding = PaddingValues(5.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_search),
                    contentDescription = "icon search",
                    modifier = Modifier
                        .size(15.dp),
                    tint = DefaultColorApp
                )
            }
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            ),
            color = Color.Black,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .width(120.dp),
            contentAlignment = Alignment.CenterEnd
        ){
            Button(
                onClick = onClickCoin,
                modifier = Modifier
                    .width(83.dp)
                    .height(26.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(1.dp),
                contentPadding = PaddingValues(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_coin),
                        contentDescription = "image coin",
                        modifier = Modifier
                            .size(15.dp),
                    )
                    Text(
                        text = 0.toString(),
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Light,
                            lineHeight = 15.sp
                        ),
                        color = Color.Black,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "image coin",
                        modifier = Modifier
                            .size(15.dp),
                        tint = DefaultColorApp
                    )
                }
            }
        }
    }
}