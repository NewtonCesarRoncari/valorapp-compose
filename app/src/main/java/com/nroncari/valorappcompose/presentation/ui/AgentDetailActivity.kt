package com.nroncari.valorappcompose.presentation.ui

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nroncari.valorappcompose.presentation.model.AgentAbilityPresentation
import com.nroncari.valorappcompose.presentation.model.AgentPresentation
import com.nroncari.valorappcompose.presentation.ui.theme.*
import dev.chrisbanes.accompanist.picasso.PicassoImage

class AgentDetailActivity : AppCompatActivity() {

    private lateinit var agent: AgentPresentation

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        agent = intent.getSerializableExtra("agent") as AgentPresentation

        setContent {
        SystemUi(windows = this.window)
            Content() 
        }
    }

    @ExperimentalFoundationApi
    @Preview
    @Composable
    private fun Content() {
        Scaffold(
            backgroundColor = background,
        ) {
            Column {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.2f)
                    ) {
                        PicassoImage(
                            modifier = Modifier.fillMaxSize(),
                            data = agent.killfeedPortrait!!,
                            contentDescription = "Agent Image",
                            contentScale = ContentScale.FillWidth
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(text = agent.displayName, style = AgentDetailNameItemTextStyle)
                            Text(text = agent.role?.displayName ?: "", style = AgentNameItemTextStyle)
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 32.dp, end = 32.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "// Biografia", style = AgentNameItemTextStyle)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = agent.description,
                        style = TextDescription
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "// Habilidades especiais", style = AgentNameItemTextStyle)
                    Spacer(modifier = Modifier.height(16.dp))
                    AbilityListContent(agent.abilities)
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun AbilityListContent(abilities: List<AgentAbilityPresentation>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = 1),
        contentPadding = PaddingValues(all = 8.dp)
    ) {
        items(abilities) { ability: AgentAbilityPresentation ->
            AbilityCardItem(ability)
        }
    }
}

@Composable
fun AbilityCardItem(ability: AgentAbilityPresentation) {
    Card(
        backgroundColor = card_color,
        modifier = Modifier
            .height(120.dp)
            .padding(bottom = 16.dp),
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            PicassoImage(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight(),
                data = ability.displayIcon ?: "",
                contentDescription = "Agent Ability"
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = ability.displayName ?: "", style = AgentNameItemTextStyle)
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    text = ability.description ?: "",
                    style = TextDescription
                )
            }
        }
    }
}

@Composable
fun SystemUi(windows: Window) =
    MaterialTheme {
//        windows.statusBarColor = MaterialTheme.colors.background.toArgb()
//        windows.navigationBarColor = MaterialTheme.colors.surface.toArgb()
//
//        @Suppress("DEPRECATION")
//        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
//            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
//                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//
//        @Suppress("DEPRECATION")
//        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
//            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
//                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
//        }
    }
