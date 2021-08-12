package com.nroncari.valorappcompose.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.ui.theme.*
import dev.chrisbanes.accompanist.picasso.PicassoImage

@Composable
fun AgentItemCard(
    agent: AgentPresentation,
    onClick: (agent: AgentPresentation) -> Unit = {}
) {
    Card(
        backgroundColor = background,
        elevation = 2.dp,
        shape = RoundedCornerShape(AllCardCornerRadius),
        modifier = Modifier
            .padding(AllPaddingHalf),
    ) {
        Box(
            modifier = Modifier
                .background(Color.Transparent)
                .size(size = ItemImageAgentSize)
                .fillMaxSize()
                .clickable(onClick = { onClick(agent) })
        ) {
            PicassoImage(
                data = agent.bustPortrait!!,
                contentDescription = "Agent Image"
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = agent.displayName, style = AgentNameItemTextStyle)
                Spacer(modifier = Modifier.size(size = AllMarginDefault))
                Text(text = agent.role!!.displayName, style = AgentRoleItemTextStyle)
            }
        }
    }
}