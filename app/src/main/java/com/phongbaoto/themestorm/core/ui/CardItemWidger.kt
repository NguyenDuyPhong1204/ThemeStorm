package com.phongbaoto.themestorm.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.phongbaoto.themestorm.R
import com.phongbaoto.themestorm.core.model.TabItem

@Preview
@Composable
private fun PreviewCardItem() {
    val tabList = listOf(
        TabItem(title = stringResource(R.string.new_text)),
        TabItem(title = stringResource(R.string.gif)),
        TabItem(title = stringResource(R.string.music)),
        TabItem(title = stringResource(R.string.time), icon = R.drawable.ic_fire)
    )
    val listLazyState = remember { tabList.map { LazyListState() } }
    val items = List(20) { "Widget Item $it" }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyVerticalStaggeredGrid(
            state = rememberLazyStaggeredGridState(),
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalItemSpacing = 5.dp
        ) {
            items(items) { item ->
                CardItemWidget(
                    title = "Widget",
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
fun CardItemWidget(
    modifier: Modifier = Modifier,
    height: Dp = 130.dp,
    title: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title
            )
        }
    }
}