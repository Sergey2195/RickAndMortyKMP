package org.rick.and.morty.character.detail.internal.presentation

import Design
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import org.rick.and.morty.character.detail.internal.domain.CharacterDetailState

@Composable
internal fun CharacterDetailView(
    state: CharacterDetailState
) {
    Scaffold(
        topBar = { TopBar(state.name) }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = state.image,
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = state.name,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp)
            )

            state.status.takeIf { it.isNotBlank() }?.let {
                Text(
                    text = "Status: $it",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            state.species.takeIf { it.isNotBlank() }?.let {
                Text(
                    text = "Species: $it",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            state.gender.takeIf { it.isNotBlank() }?.let {
                Text(
                    text = "Gender: $it",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Text(
                text = "Location",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp)
            )

            Text(
                text = state.location.locationName,
                modifier = Modifier.padding(start = 16.dp)
            )

            Text(
                text = "Episodes",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp)
            )

            state.episodes.forEach {
                Text(
                    text = "${it.episodeCount} - ${it.episodeName}",
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.systemBars))
        }
    }
}

@Composable
private fun TopBar(name: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 8.dp)
            .statusBarsPadding()
    ) {
        Text(
            text = name.take(20),
            color = Design.Colors.textPrimary,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Icon(
            imageVector = Icons.Filled.ArrowBackIosNew,
            contentDescription = "back",
            modifier = Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }) { /*TODO*/ }
        )
    }
}