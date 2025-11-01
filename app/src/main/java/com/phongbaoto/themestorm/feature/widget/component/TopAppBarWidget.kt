package com.phongbaoto.themestorm.feature.widget.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.theme.GrayColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWidget(
    onClose: () -> Unit,
    onClickInfo: () -> Unit,
    onClickFavorite: () -> Unit
) {
    TopAppBar(
        modifier = Modifier,
        windowInsets = WindowInsets(0,0,0,0),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(
                text = stringResource(R.string.widget_size),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onClose,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .size(30.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_close_2),
                    contentDescription = "Icon back",
                    modifier = Modifier
                        .size(12.dp),
                    tint = Color.Unspecified
                )
            }
        },
        actions = {
            Row(
                modifier = Modifier
                    .height(30.dp)
                    .background(Color.White, shape = RoundedCornerShape(100.dp))
            ) {
                IconButton(
                    onClick = onClickInfo
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_infomation),
                        contentDescription = "icon information",
                        modifier = Modifier
                            .size(15.dp),
                        tint = Color.Unspecified
                    )
                }
                VerticalDivider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(vertical = 5.dp),
                    color = GrayColor
                )
                IconButton(
                    onClick = onClickFavorite
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_love),
                        contentDescription = "icon information",
                        modifier = Modifier
                            .size(15.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        }
    )
}