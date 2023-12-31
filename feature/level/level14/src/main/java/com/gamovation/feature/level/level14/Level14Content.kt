package com.gamovation.feature.level.level14

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.gamovation.core.domain.level.LevelScreenState
import com.gamovation.core.ui.Dimensions
import com.gamovation.core.ui.level.interactions.CollisionImage
import com.gamovation.core.ui.level.interactions.DraggableText
import com.gamovation.core.ui.state.LocalLevelScreen

@Composable
fun Level14Content(
    modifier: Modifier = Modifier,
    onLevelAction: (LevelScreenState) -> Unit
) {
    val levelScreenState = LocalLevelScreen.current
    var positionOfText by remember { mutableStateOf(Offset.Zero) }

    BoxWithConstraints(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleContent(
                isEnabled = levelScreenState !is LevelScreenState.UserCorrectChoice,
                onUpdatePosition = {
                    positionOfText = it
                }
            )
            Spacer(modifier = Modifier.width(Dimensions.Padding.Small.value))
            SheepContent(
                positionOfText = positionOfText,
                onLevelAction = onLevelAction
            )
        }
    }
}

@Composable
fun TitleContent(isEnabled: Boolean, onUpdatePosition: (Offset) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.l14_where_is_a),
            style = MaterialTheme.typography.headlineSmall,
            maxLines = 1
        )
        Spacer(modifier = Modifier.width(Dimensions.Padding.ExtraSmall.value))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            DraggableText(
                text = stringResource(R.string.l14_black),
                style = MaterialTheme.typography.headlineSmall,
                isEnabled = isEnabled
            ) { offset, _ ->
                onUpdatePosition(offset)
            }
            Spacer(modifier = Modifier.width(Dimensions.Padding.Small.value))
            Text(
                text = stringResource(R.string.l14_sheep),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun SheepContent(positionOfText: Offset, onLevelAction: (LevelScreenState) -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.Padding.Medium.value)
    ) {
        val (sheep1, sheep2, sheep3) = createRefs()

        val verticalGuideLine = createGuidelineFromStart(0.5f)
        CollisionImage(
            modifier = Modifier
                .constrainAs(sheep1) {
                    width = Dimension.fillToConstraints
                    height = Dimension.ratio("1:1")
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(verticalGuideLine)
                    bottom.linkTo(sheep2.top)
                },
            matchedDrawableRes = R.drawable.l14_black_sheep,
            notMatchedDrawableRes = R.drawable.l14_white_sheep,
            outerOffset = positionOfText,
        ) {
            onLevelAction(
                LevelScreenState.UserCorrectChoice(
                    com.gamovation.core.domain.R.string.event_level_14_finished
                )
            )
        }
        CollisionImage(
            modifier = Modifier
                .constrainAs(sheep2) {
                    width = Dimension.fillToConstraints
                    height = Dimension.ratio("1:1")
                    top.linkTo(parent.top)
                    start.linkTo(verticalGuideLine)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            matchedDrawableRes = R.drawable.l14_black_sheep,
            notMatchedDrawableRes = R.drawable.l14_white_sheep,
            outerOffset = positionOfText,
            appearOrder = 1
        ) {
            onLevelAction(
                LevelScreenState.UserCorrectChoice(
                    com.gamovation.core.domain.R.string.event_level_14_finished
                )
            )
        }
        CollisionImage(
            modifier = Modifier
                .constrainAs(sheep3) {
                    width = Dimension.fillToConstraints
                    height = Dimension.ratio("1:1")
                    top.linkTo(sheep2.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(verticalGuideLine)
                    bottom.linkTo(parent.bottom)
                },
            matchedDrawableRes = R.drawable.l14_black_sheep,
            notMatchedDrawableRes = R.drawable.l14_white_sheep,
            outerOffset = positionOfText,
            appearOrder = 2
        ) {
            onLevelAction(
                LevelScreenState.UserCorrectChoice(
                    com.gamovation.core.domain.R.string.event_level_14_finished
                )
            )
        }
    }
}

@Preview
@Composable
fun Level14ContentPreview() {
    Level14Content(onLevelAction = {})
}
