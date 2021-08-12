package com.nroncari.valorappcompose.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.nroncari.valorappcompose.R
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.model.WeaponPresentation
import com.nroncari.valorappcompose.presentation.model.WeaponSkinPresentation
import com.nroncari.valorappcompose.presentation.ui.adapter.tabs.Tabs
import com.nroncari.valorappcompose.presentation.ui.adapter.tabs.TabsContent
import com.nroncari.valorappcompose.presentation.ui.items.SkinCarouselItem
import com.nroncari.valorappcompose.presentation.ui.items.TabItem
import com.nroncari.valorappcompose.presentation.ui.theme.TextHome
import com.nroncari.valorappcompose.presentation.ui.theme.background
import com.nroncari.valorappcompose.presentation.ui.theme.titleCarrousel
import com.nroncari.valorappcompose.presentation.viewModel.AgentListViewModel
import com.nroncari.valorappcompose.presentation.viewModel.WeaponListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private var agents: List<AgentPresentation> = listOf()
    private var weapons: List<WeaponPresentation> = listOf()
    private val agentViewModel: AgentListViewModel by viewModel()
    private val weaponViewModel: WeaponListViewModel by viewModel()
    private var weaponSkinsList: List<WeaponSkinPresentation> = listOf()

    @ExperimentalAnimationApi
    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            agentViewModel.getAgents()
            weaponViewModel.getWeapons()
            HomeFragment()
        }
    }

    @ExperimentalAnimationApi
    @ExperimentalPagerApi
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    @Composable
    fun HomeFragment() {
        val showSkinCarousel = remember { mutableStateOf(false) }
        val agentsReturned = remember { mutableStateOf(false) }
        val weaponsReturned = remember { mutableStateOf(false) }

        agentViewModel.agents.observe(this, { agentList ->
            this.agents = agentList
            agentsReturned.value = true
        })
        weaponViewModel.weapons.observe(this, { weaponList ->
            this.weapons = weaponList
            weaponsReturned.value = true
        })

        Scaffold(
            backgroundColor = background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp),
                    painter = painterResource(id = R.drawable.logo_valorant),
                    contentScale = ContentScale.Crop,
                    contentDescription = "logo"
                )
                Text(text = "Procure pelo seu agente", style = TextHome)

                androidx.compose.animation.AnimatedVisibility(
                    visible = agentsReturned.value && weaponsReturned.value,
                    enter = expandVertically(animationSpec = tween(durationMillis = 1000)),
                    exit = shrinkVertically(),
                ) {
                    if (agentsReturned.value && weaponsReturned.value) {
                        val tabs = listOf(
                            TabItem.Agents(
                                listAgent = agents,
                                onClick = { agentPresentation ->
                                    showAgentDetailActivity(agentPresentation)
                                }),
                            TabItem.Weapons(
                                listWeapon = weapons,
                                onClick = { weaponPresentation ->
                                    weaponSkinsList =
                                        weaponPresentation.skins.filter { skin ->
                                            skin.displayIcon.isNotEmpty()
                                        }
                                    showSkinCarousel.value = true
                                }),
                        )

                        val pagerState = rememberPagerState(pageCount = tabs.size)

                        val carouselPagerState = rememberPagerState(
                            pageCount = 5,
                            initialOffscreenLimit = 2,
                        )

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Tabs(tabs = tabs, pagerState = pagerState)
                            Box(contentAlignment = Alignment.BottomCenter) {
                                TabsContent(tabs = tabs, pagerState = pagerState)
                                androidx.compose.animation.AnimatedVisibility(
                                    visible = showSkinCarousel.value,
                                    enter = expandVertically(animationSpec = tween(durationMillis = 1000)),
                                    exit = shrinkVertically(),
                                ) {
                                    Column {
                                        SkinsCarousel(
                                            onClick = { showSkinCarousel.value = false },
                                            items = weaponSkinsList,
                                            pagerState = carouselPagerState
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showAgentDetailActivity(agent: AgentPresentation) {
        intent = Intent(this, AgentDetailActivity::class.java)
        intent.putExtra("agent", agent)
        startActivity(intent)
    }
}

@ExperimentalPagerApi
@Composable
fun SkinsCarousel(
    onClick: () -> Unit = {},
    items: List<WeaponSkinPresentation> = listOf(),
    pagerState: PagerState,
) {
    Column {
        Text(
            text = "Skins",
            style = titleCarrousel,
            modifier = Modifier
                .padding(start = 24.dp)
                .background(background)
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
        ) { page ->
            val (_, _, _, displayIcon, _) = items[page]
            SkinCarouselItem(onClick = onClick, skinImageUrl = displayIcon)
        }
    }
}

