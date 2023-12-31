package com.gamovation.feature.level.level3

import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.gamovation.core.ui.Dimensions
import com.gamovation.core.ui.animation.DrawAnimation
import com.gamovation.core.ui.animation.Durations
import com.gamovation.core.ui.clickableNoRipple

@Composable
internal fun Level3IceCream(
    modifier: Modifier = Modifier,
    index: Int,
    transition: Transition<Boolean>,
    isNotIceCream: Boolean,
    onClick: () -> Unit
) {
    val iceCreamScaleAnimation by transition.animateFloat(
        transitionSpec = {
            tween(Durations.Long.time)
        },
        label = ""
    ) { state ->
        if (state) 0.75F else 1F
    }
    val flyScaleAnimation by transition.animateFloat(
        transitionSpec = {
            tween(Durations.Long.time)
        },
        label = ""
    ) { state ->
        if (state) 1F else 0F
    }

    DrawAnimation(
        modifier = modifier
            .clickableNoRipple(
                enabled = transition.currentState,
                onClick = onClick
            )
            .scale(scaleX = 1F, scaleY = iceCreamScaleAnimation)
            .padding(Dimensions.Padding.ExtraSmall.value),
        appearOrder = 1 + index
    ) {
        Image(
            painter = painterResource(id = R.drawable.l3_ice_cream),
            contentDescription = null
        )
        if (isNotIceCream) {
            Image(
                modifier = Modifier.scale(flyScaleAnimation),
                painter = painterResource(id = R.drawable.l3_fly),
                contentDescription = null
            )
        }
    }
}
