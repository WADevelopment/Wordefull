package com.gamovation.feature.home

import androidx.lifecycle.ViewModel
import com.gamovation.core.data.repository.OfflineLevelManagerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val levelDataRepositoryImpl: OfflineLevelManagerRepository
) : ViewModel() {

    fun getLastUncompleted() = levelDataRepositoryImpl.getLastUncompleted()
}
