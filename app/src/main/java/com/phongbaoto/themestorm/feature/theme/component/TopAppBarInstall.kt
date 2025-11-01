package com.phongbaoto.themestorm.feature.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.theme.DefaultColorApp
import com.phongbaoto.themestorm.core.theme.GrayColor
import com.phongbaoto.themestorm.core.ui.SpaceRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarInstall(
    title: String,
    onNavBack: () -> Unit,
    onClickQuestion: () -> Unit,
    onClickCoin: () -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .statusBarsPadding(),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            Row {
                IconButton(
                    onClick = onNavBack,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Icon back",
                        modifier = Modifier,
                        tint = GrayColor
                    )
                }
                SpaceRow(10.dp)
                IconButton(
                    onClick = onClickQuestion,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_question_2),
                        contentDescription = "Icon back",
                        modifier = Modifier
                            .size(20.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        },
        actions = {
            Box(
                modifier = Modifier
                    .width(83.dp)
                    .height(40.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(
                    onClick = onClickCoin,
                    modifier = Modifier
                        .width(83.dp)
                        .height(30.dp),
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
    )
}