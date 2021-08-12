package com.nroncari.valorappcompose.presentation.ui.fragment

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nroncari.valorappcompose.presentation.model.WeaponPresentation
import com.nroncari.valorappcompose.presentation.ui.items.WeaponCardItem

@ExperimentalPagerApi
@SuppressLint("UnrememberedMutableState")
@ExperimentalFoundationApi
@Composable
fun WeaponListContent(
    listWeapon: List<WeaponPresentation> = listOf(),
    onClick: (weapon: WeaponPresentation) -> Unit = {}
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 1),
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(
            listWeapon
        ) { weapon: WeaponPresentation ->
            WeaponCardItem(
                weapon = weapon,
                onClick = onClick
            )
        }
    }
}

