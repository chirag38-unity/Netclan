package com.chirag_redij.netclan.Homescreen.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.chirag_redij.netclan.Homescreen.Constants.peopleList
import com.chirag_redij.netclan.Homescreen.Constants.tabItemsList
import com.chirag_redij.netclan.Homescreen.ExploreScreenFAB
import com.chirag_redij.netclan.Homescreen.SearchSection
import com.chirag_redij.netclan.Homescreen.UserTile.UserTileComposable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(

) {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItemsList.size
    }
    LaunchedEffect( selectedItem ) {
        pagerState.animateScrollToPage(selectedItem)
    }
    LaunchedEffect( pagerState.currentPage, pagerState.isScrollInProgress ) {
        if(!pagerState.isScrollInProgress) {
            selectedItem = pagerState.currentPage
        }
    }

    Scaffold (
        floatingActionButton = {
            ExploreScreenFAB()
        }
    ) { paddingValues ->

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            TabRow(
                selectedTabIndex = selectedItem,
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary,
            ) {
                tabItemsList.forEachIndexed { index, tabItem ->
                    Tab(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        text = {
                            Text(text = tabItem.title)
                        },
                        selectedContentColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedContentColor = Color(0xFFaeb0b4)
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { index ->
                Column {

                    SearchSection()
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        items(count = peopleList.size) {
                            UserTileComposable(userTile = peopleList[it])
                        }
                    }
                }
            }
        }
    }

}

data class TabItem (
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector
)