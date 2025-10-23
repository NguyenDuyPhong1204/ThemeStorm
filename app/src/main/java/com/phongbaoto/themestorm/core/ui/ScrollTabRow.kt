package com.phongbaoto.themestorm.core.ui

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phongbaoto.themestorm.core.model.ItemTheme
import com.phongbaoto.themestorm.core.model.TabItem
import com.phongbaoto.themestorm.core.theme.DefaultLineColor

@Composable
fun ScrollTabRow(
    listTab: List<TabItem>,
    isGridLayout: Boolean = true,
    onClickItem: (ItemTheme) -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val listGridState = remember { listTab.map { LazyGridState() } }
    val listLazyStaggeredGirdState = remember { listTab.map { LazyStaggeredGridState() } }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScrollableTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            edgePadding = 0.dp,
            indicator = { tabPositon ->
                val currentTabPosition = tabPositon[selectedTabIndex]
                val indicatorWidth = 40.dp
                val indicatorOffset by animateDpAsState(
                    targetValue = currentTabPosition.left + (currentTabPosition.width - indicatorWidth) / 2,
                    animationSpec = tween(durationMillis = 250, easing = LinearOutSlowInEasing),
                    label = "indicator_offset"
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.BottomStart)
                        .offset(x = indicatorOffset)
                        .width(indicatorWidth)
                        .height(2.dp)
                        .background(DefaultLineColor, RoundedCornerShape(50))
                )
            },
            divider = {}
        ) {
            listTab.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    modifier = Modifier
                        .padding(vertical = 5.dp, horizontal = 5.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        tab.icon?.let {
                            Icon(
                                painter = painterResource(it),
                                contentDescription = "tab icon",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                        SpaceRow(5.dp)
                        Text(
                            text = tab.title,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = Color.Black
                        )
                    }
                }
            }

        }
        TabContent(
            listItem = listTab[selectedTabIndex].listTheme,
            isGridLayout = isGridLayout,
            onClickItem = {
                onClickItem(it)
            },
            state = listGridState[selectedTabIndex],
            lazyStaggeredGridState = listLazyStaggeredGirdState[selectedTabIndex]
        )
    }
}

@Composable
fun TabContent(
    isGridLayout: Boolean = true,
    onClickItem: (ItemTheme) -> Unit,
    listItem: List<ItemTheme>,
    state: LazyGridState = remember { LazyGridState() },
    lazyStaggeredGridState: LazyStaggeredGridState = remember { LazyStaggeredGridState() }
) {
    val items = List(20) { "Widget Item $it" }
    if (isGridLayout) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(bottom = 5.dp)
        ) {
            items(listItem) { item ->
                ItemCard(
                    item = item,
                    modifier = Modifier,
                    onClickItem = {
                        onClickItem(item)
                    }
                )
            }
        }
    } else {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            state = lazyStaggeredGridState,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalItemSpacing = 5.dp,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(bottom = 5.dp)
        ) {
            itemsIndexed(
                items = listItem,
                span = { index, _ ->
                    // index % 3 == 0 → full width
                    // index % 3 == 1 hoặc 2 → half width
                    if (index % 3 == 0) {
                        StaggeredGridItemSpan.FullLine
                    } else {
                        StaggeredGridItemSpan.SingleLane
                    }
                }
            ) { index, item ->
                CardItemWidget(
                    item = item,
                    modifier = Modifier,
                    onClickItem = {
                        onClickItem(item)
                    }
                )
            }
        }
    }
}