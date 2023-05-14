package com.conboi.feature.level.all.level_7

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import com.conboi.core.domain.level.LevelScreenState
import com.conboi.core.ui.R
import com.conboi.feature.level.common.answers.NumbersBlock
import com.conboi.feature.level.common.interactions.DraggableImage

@Composable
fun Level7Content(modifier: Modifier = Modifier, onLevelAction: (LevelScreenState) -> Unit) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        BoxWithConstraints(modifier = Modifier.weight(0.2F), contentAlignment = Alignment.Center) {
            Text("15")
            DraggableImage(
                drawableRes = R.drawable.lamp,
                maxSize = Offset(maxWidth.value, maxHeight.value)
            ) {

            }
        }

        NumbersBlock(modifier = Modifier.weight(1F), numberMaxLength = 2) {
            if (it == "15") {
                onLevelAction(LevelScreenState.CORRECT_CHOICE)
            } else {
                onLevelAction(LevelScreenState.WRONG_CHOICE)
            }
        }
    }
}