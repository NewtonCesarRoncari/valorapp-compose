package com.nroncari.valorappcompose.presentation.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.nroncari.valorappcompose.presentation.ui.theme.background
import dev.chrisbanes.accompanist.picasso.PicassoImage

@Composable
fun SkinCarouselItem(
    onClick: () -> Unit = {},
    skinImageUrl: String = "https://media.valorant-api.com/weaponskins/0eab3e5c-4de4-e221-34fb-2ab435c89eb6/displayicon.png",
) {
    Column {
        Box(
            Modifier
                .background(background)
                .weight(1f)
                .align(Alignment.CenterHorizontally)
                .padding(32.dp)
                .clickable(onClick = { onClick() })
        ) {
            if (skinImageUrl.isNotEmpty()) {
                PicassoImage(
                    data = skinImageUrl,
                    contentDescription = "Agent Image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium),
                )
            }
        }
    }
}