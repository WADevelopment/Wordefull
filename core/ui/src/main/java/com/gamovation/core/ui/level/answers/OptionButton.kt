package com.gamovation.core.ui.level.answers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.gamovation.core.ui.Dimensions
import com.gamovation.core.ui.R
import com.gamovation.core.ui.common.ScalableButton

@Composable
fun OptionButton(
    modifier: Modifier = Modifier,
    text: String,
    appearOrder: Int,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    onClick: () -> Unit
) {
    ScalableButton(
        modifier = modifier,
        appearOrder = appearOrder,
        onClick = onClick
    ) {
        Card(
            shape = Dimensions.RoundedShape.Medium.value
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.button),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    text = text,
                    style = style.copy(color = MaterialTheme.colorScheme.onPrimary)
                )
            }
        }
    }
}
