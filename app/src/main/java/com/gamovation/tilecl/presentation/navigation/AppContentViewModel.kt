package com.gamovation.tilecl.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamovation.core.data.billing.BillingDataSource
import com.gamovation.core.data.repository.OfflineUserInfoPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppContentViewModel @Inject constructor(
    private val userInfoPreferencesRepository: OfflineUserInfoPreferencesRepository,
    private val billingDataSource: BillingDataSource
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        billingDataSource.endConnection()
    }

    init {
        billingDataSource.initClient()
    }

    fun getUserCurrency() = userInfoPreferencesRepository.getUserCurrency()

    fun getUserVipType() = userInfoPreferencesRepository.getUserVipType()
    fun queryProducts() = viewModelScope.launch(Dispatchers.IO) {
        billingDataSource.queryProductDetails()
    }


    fun onResumeBilling(){
        billingDataSource.onResumeBilling()
    }

}