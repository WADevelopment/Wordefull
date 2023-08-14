package com.gamovation.feature.store.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.android.billingclient.api.ProductDetails
import com.gamovation.core.data.billing.BillingProductType
import com.gamovation.core.ui.Dimensions
import com.gamovation.core.ui.R
import com.gamovation.core.ui.billing.BuyButton
import com.gamovation.core.ui.common.ChalkBoardCard
import com.gamovation.core.ui.theme.boardBorderColor
import kotlin.math.roundToInt

@Composable
fun CoolestOfferContent(
    modifier: Modifier = Modifier,
    details: ProductDetails?,
    onClick: (ProductDetails, BillingProductType) -> Unit
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Card(colors = CardDefaults.cardColors(boardBorderColor),
            modifier = Modifier
                .zIndex(2F)
                .offset {
                    IntOffset(0, +Dimensions.Padding.Large.value.value.roundToInt())
                }
                .fillMaxWidth()
        ) {
            Text(
                text = "Smartest",
                modifier = Modifier.padding(Dimensions.Padding.Medium.value),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )
        }
        ChalkBoardCard(
            modifier = Modifier
                .zIndex(1F),
            color = Color.White.copy(alpha = 0.7F)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.lamp),
                        modifier = Modifier.size(32.dp),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                    Spacer(modifier = Modifier.width(Dimensions.Padding.Small.value))
                    Image(
                        painter = painterResource(id = R.drawable.remove_ads),
                        modifier = Modifier.size(32.dp),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
                Spacer(modifier = Modifier.height(Dimensions.Padding.Small.value))
                BuyButton(text = details?.oneTimePurchaseOfferDetails?.formattedPrice ?: "",
                    onClick = {
                        details?.let {
                            onClick(it, BillingProductType.COOLEST_OFFER)
                        }
                    })
            }
        }
    }
}