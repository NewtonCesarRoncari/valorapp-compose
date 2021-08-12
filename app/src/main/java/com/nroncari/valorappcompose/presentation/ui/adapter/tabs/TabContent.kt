package com.nroncari.valorappcompose.presentation.ui.adapter.tabs

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.nroncari.valorappcompose.presentation.ui.items.TabItem

@ExperimentalPagerApi
@Composable
fun TabsContent(
    tabs: List<TabItem>,
    pagerState: PagerState
) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}