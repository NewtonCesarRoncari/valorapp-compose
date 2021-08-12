package com.nroncari.valorappcompose.presentation.ui.fragment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.ui.items.AgentItemCard

@ExperimentalFoundationApi
@Composable
fun AgentListContent(
    listAgent: List<AgentPresentation> = listOf(),
    onClick: (agent: AgentPresentation) -> Unit = {}
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(
            listAgent
        ) { agent: AgentPresentation ->
            AgentItemCard(
                agent = agent,
                onClick = onClick
            )
        }
    }
}