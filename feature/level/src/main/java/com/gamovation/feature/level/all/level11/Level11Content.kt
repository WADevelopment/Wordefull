package com.gamovation.feature.level.all.level11

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.gamovation.core.domain.level.LevelScreenState
import com.gamovation.core.ui.Dimensions
import com.gamovation.core.ui.extensions.clickableNoRipple
import com.gamovation.feature.level.R

@Composable
fun Level11Content(modifier: Modifier = Modifier, onLevelAction: (LevelScreenState) -> Unit) {
    val listOfOptions = listOf(
        stringResource(R.string.l11_dog),
        stringResource(R.string.l11_mewka),
        stringResource(R.string.l11_murka),
        stringResource(R.string.l11_kilen),
        stringResource(R.string.l11_cow)
    )
    var isCorrect by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = stringResource(R.string.l11_what_are_the_names_of_baby),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.width(Dimensions.Padding.ExtraSmall.value))
            Text(
                text = stringResource(R.string.l11_cats),
                modifier = Modifier.clickable {
                    isCorrect = true
                    onLevelAction(LevelScreenState.CORRECT_CHOICE)
                },
                style = MaterialTheme.typography.titleLarge,
                textDecoration = if (isCorrect) TextDecoration.Underline else TextDecoration.None
            )
        }

        Spacer(modifier = Modifier.height(Dimensions.Padding.Medium.value))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimensions.Padding.Medium.value)
        ) {
            listOfOptions.forEach {
                Card(
                    border = BorderStroke(4.dp, Color.White),
                    shape = Dimensions.RoundedShape.Large.value,
                    colors = CardDefaults.cardColors(Color.Transparent)
                ) {
                    Text(
                        text = it,
                        modifier = Modifier
                            .clickableNoRipple {
                                onLevelAction(LevelScreenState.WRONG_CHOICE)
                            }
                            .padding(Dimensions.Padding.Small.value),
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}