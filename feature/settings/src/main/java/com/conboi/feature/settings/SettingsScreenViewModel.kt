package com.conboi.feature.settings

import androidx.lifecycle.ViewModel
import com.conboi.core.data.billing.BillingDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsScreenViewModel @Inject constructor(
    private val billingDataSource: BillingDataSource
) :
    ViewModel() {
    fun restorePurchases() {
        billingDataSource.restorePurchases()
    }
}