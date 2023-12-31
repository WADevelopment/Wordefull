package com.gamovation.feature.level.level16

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.gamovation.core.domain.level.LevelScreenState
import com.gamovation.core.ui.animation.DrawAnimation
import com.gamovation.core.ui.clickableNoRipple
import com.gamovation.core.ui.level.interactions.CollisionImage
import com.gamovation.core.ui.level.interactions.DraggableImage
import com.gamovation.core.ui.theme.WordefullTheme

@Composable
fun Level16Content(
    modifier: Modifier = Modifier,
    onLevelAction: (LevelScreenState) -> Unit
) {
    var positionOfBowl by remember { mutableStateOf(Offset.Zero) }
    var isBowlShown by remember { mutableStateOf(false) }

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (cat, bowl, food, plate) = createRefs()

        createHorizontalChain(
            plate,
            cat,
            food
        )

        DrawAnimation(
            Modifier.constrainAs(cat) {
                width = Dimension.fillToConstraints
                height = Dimension.ratio("1:1")
                centerVerticallyTo(parent)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.l16_cat),
                contentDescription = null
            )
        }

        DrawAnimation(modifier = Modifier
            .constrainAs(food) {
                width = Dimension.fillToConstraints
                centerVerticallyTo(parent)
            }
            .clickableNoRipple {
                isBowlShown = true
            },
            appearOrder = 1
        ) {
            Image(
                painter = painterResource(id = R.drawable.l16_food),
                contentDescription = null
            )
        }
        CollisionImage(
            defaultDrawableRes = R.drawable.l16_plate,
            modifier = Modifier.constrainAs(plate) {
                width = Dimension.fillToConstraints
                height = Dimension.ratio("4:3")
                centerAround(cat.bottom)
            },
            outerOffset = positionOfBowl,
            appearOrder = 2
        ) {
            onLevelAction(
                LevelScreenState.UserCorrectChoice(
                    com.gamovation.core.domain.R.string.event_level_16_finished
                )
            )
        }

        Crossfade(
            modifier = Modifier.constrainAs(bowl) {
                width = Dimension.fillToConstraints
                height = Dimension.ratio("4:3")
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            targetState = isBowlShown,
            label = ""
        ) {
            if (it) {
                DrawAnimation {
                    DraggableImage(
                        drawableRes = R.drawable.l16_bowl
                    ) { bowlOffset, _ ->
                        positionOfBowl = bowlOffset
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Level16ContentPreview() {
    WordefullTheme {
        Level16Content(onLevelAction = {})
    }
}
