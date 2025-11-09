package com.phongbaoto.themestorm.feature.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.theme.DefaultBackGroundColor
import com.phongbaoto.themestorm.core.ui.SpaceColumn
import kotlinx.coroutines.launch

@Composable
fun InstallWidgetRoute(
    onNavBack: () -> Unit
) {
    InstallWidgetScreen(
        onNavBack = onNavBack
    )
}

@Composable
private fun InstallWidgetScreen(
//    item: ItemTheme
    onNavBack: () -> Unit
) {
    val pages = listOf("2x2", "4x2", "4x4")
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DefaultBackGroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpaceColumn(20.dp)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onNavBack,
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(50.dp)),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.White
                )
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_close_2),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(10.dp),
                    tint = Color.Unspecified
                )
            }
            Text(
                text = stringResource(R.string.install_widget),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp),
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .height(150.dp),
                contentPadding = PaddingValues(horizontal = 60.dp),
                pageSpacing = 24.dp
            ) { page ->
                Image(
                    painter = painterResource(id = R.drawable.demo_image_theme),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }

            SpaceColumn(24.dp)
            // --- Page indicator ---
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(pages.size) { index ->
                    val selected = pagerState.currentPage == index
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(if (selected) 8.dp else 6.dp)
                            .clip(CircleShape)
                            .background(if (selected) Color(0xFF7B61FF) else Color.LightGray)
                            .clickable {
                                scope.launch { pagerState.animateScrollToPage(index) }
                            }
                    )
                }
            }
            SpaceColumn(70.dp)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
//                    .clickable(onClick = onDownload)
                    .fillMaxWidth(0.7f)
                    .height(48.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFD134F8),
                                Color(0xFF9939F2),
                                Color(0xFF6B79F3),
                                Color(0xFF457CF3)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.download),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}