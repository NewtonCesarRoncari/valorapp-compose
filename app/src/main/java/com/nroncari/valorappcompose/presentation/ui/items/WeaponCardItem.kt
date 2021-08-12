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
import com.nroncari.valorappcompose.presentation.model.WeaponPresentation
import com.nroncari.valorappcompose.presentation.ui.theme.*
import dev.chrisbanes.accompanist.picasso.PicassoImage

@Composable
fun WeaponCardItem(
    weapon: WeaponPresentation,
    onClick: (weapon: WeaponPresentation) -> Unit = {}
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
                .clickable(onClick = { onClick(weapon) })
        ) {
            PicassoImage(
                modifier = Modifier.fillMaxSize(),
                data = weapon.displayIcon,
                contentDescription = "Weapon Image"
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(text = weapon.displayName, style = AgentNameItemTextStyle)
                Text(text = "EEquippableCategory::Heavy", style = AgentRoleItemTextStyle)
            }
        }
    }
}