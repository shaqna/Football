package com.maou.footballstandings.presentation.screens.club

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maou.footballstandings.data.ScoreRepository
import com.maou.footballstandings.model.ClubInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModelOf


class ClubViewModel (private val repository: ScoreRepository ): ViewModel() {


    private val _state: MutableStateFlow<ClubUiState> = MutableStateFlow(ClubUiState())
    val clubUiState get() = _state.asStateFlow()

    fun processIntent(intent: ClubIntent) {
        when(intent) {
            is ClubIntent.OnSaveClubInfo -> saveClubInfo(intent.clubInfo)
        }
    }

    private fun saveClubInfo(clubInfo: ClubInfo) {
        viewModelScope.launch {
            repository.saveClubInfo(clubInfo).collect {
                _state.value = ClubUiState(it)
            }
        }
    }

    companion object {
        fun inject() = module {
            viewModelOf(::ClubViewModel)
        }
    }
}

sealed interface ClubIntent {
 data class OnSaveClubInfo(val clubInfo: ClubInfo): ClubIntent
}

data class ClubUiState(
    val message: String = "",
)