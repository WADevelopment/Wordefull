package com.gamovation.core.ui.level.interactions

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import com.gamovation.core.ui.animation.DrawAnimation

@Composable
fun CollisionImage(
    modifier: Modifier = Modifier,
    @DrawableRes defaultDrawableRes: Int? = null,
    @DrawableRes matchedDrawableRes: Int? = null,
    @DrawableRes notMatchedDrawableRes: Int? = null,
    outerOffset: Offset,
    appearOrder: Int? = 0,
    onMatch: () -> Unit
) {
    var rectOfImage by remember { mutableStateOf<Rect?>(null) }
    var isMatched by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(outerOffset) {
        if (rectOfImage?.contains(outerOffset) == true) {
            isMatched = true
            onMatch()
        }
    }

    val drawableRes = defaultDrawableRes ?: run {
        if (isMatched) {
            matchedDrawableRes
        } else {
            notMatchedDrawableRes
        }
    } ?: return

    DrawAnimation(
        modifier = modifier.onGloballyPositioned { coordinates ->
            rectOfImage = coordinates.boundsInWindow()
        },
        appearOrder = appearOrder
    ) {
        Image(
            painter = painterResource(id = drawableRes),
            contentDescription = null
        )
    }
}
