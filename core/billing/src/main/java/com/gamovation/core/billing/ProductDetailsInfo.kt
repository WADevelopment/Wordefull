package com.gamovation.core.billing

import com.android.billingclient.api.ProductDetails

data class ProductDetailsInfo(
    val inAppDetails: List<ProductDetails>?,
    val subscriptionDetails: List<ProductDetails>?
)
