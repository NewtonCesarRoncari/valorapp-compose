package com.nroncari.valorappcompose.presentation.ui.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.semantics.Role
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.model.AgentRolePresentation
import com.nroncari.valorappcompose.presentation.model.WeaponPresentation
import com.nroncari.valorappcompose.presentation.ui.fragment.AgentListContent
import com.nroncari.valorappcompose.presentation.ui.fragment.WeaponListContent

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {

    @ExperimentalFoundationApi
    class Agents(
        listAgent: List<AgentPresentation> = listOf(),
        onClick: (agent: AgentPresentation) -> Unit = {}
    ) :
        TabItem("Agentes", {
            AgentListContent(listAgent = listAgent, onClick = onClick)
        })

    @ExperimentalPagerApi
    @ExperimentalFoundationApi
    class Weapons(
        listWeapon: List<WeaponPresentation> = listOf(),
        onClick: (weapon: WeaponPresentation) -> Unit
    ) : TabItem("Armas", {
        WeaponListContent(listWeapon = listWeapon, onClick = onClick)
    })
}
