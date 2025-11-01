package com.phongbaoto.themestorm.feature.theme.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.IconThem
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.core.theme.DefaultColorApp
import com.phongbaoto.themestorm.core.ui.SpaceRow

@Composable
fun ItemChangeTheme(
    isSelected: Boolean,
    itemTheme: IconThem,
    onClickItem: (IconThem) -> Unit,
    onClickChangeIcon: () -> Unit,
    onUnlockIconTheme: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = {
                    onClickItem(itemTheme)
                },
                colors = RadioButtonDefaults.colors(
                    selectedColor = DefaultColorApp,
                    unselectedColor = DefaultColorApp
                )
            )
            SpaceRow(10.dp)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(48.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.chrome),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "Default Icon"
                )
            }
            SpaceRow(10.dp)
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow Icon",
                tint = DefaultColorApp
            )
            SpaceRow(10.dp)
            Box(
                modifier = Modifier.size(56.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(color = Color.White)
                        .padding(5.dp)
                ) {
                    Image(
                        painter = painterResource(itemTheme.imageRes),
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "Theme Icon"
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .size(20.dp)
                        .background(color = Color(0xFFC8C8C8))
                        .border(width = 1.dp, color = Color.White, shape = CircleShape)
                        .clickable(onClick = onClickChangeIcon),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(10.dp)
                    )
                }
            }
        }

        Button(
            onClick = onUnlockIconTheme,
            modifier = Modifier
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DefaultColorApp,
                contentColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_play_button),
                    contentDescription = "Icon watch Ad",
                    modifier = Modifier
                        .size(25.dp)
                )
                SpaceRow(10.dp)
                Text(
                    text = stringResource(R.string.unlock),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}