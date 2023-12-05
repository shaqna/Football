package com.maou.footballstandings.presentation.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maou.footballstandings.data.ScoreRepository
import com.maou.footballstandings.model.ClubCompeting
import com.maou.footballstandings.model.ClubInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModelOf

class ScoreViewModel(private val repository: ScoreRepository) : ViewModel() {

    private val _state = MutableStateFlow(ScoreUiState())
    val state get() = _state

    private val _stateClubs = MutableStateFlow(ClubsUiState())
    val stateClubs get() = _stateClubs

    fun processIntent(intent: ScoreIntent) {
        when(intent) {
            is ScoreIntent.OnUpdateClubScoreCompeting -> updateClubScoreCompeting(intent.clubCompeting)
            is ScoreIntent.OnUpdateListClubScoreCompeting -> updateListClubScoreCompeting(intent.list)
            ScoreIntent.OnFetchClubsInfo -> fetchClubs()
        }
    }

    private fun updateClubScoreCompeting(clubCompeting: ClubCompeting) {
        viewModelScope.launch {
            repository.updateClubScore(clubCompeting).collect {
                _state.value = ScoreUiState(it)
            }
        }
    }

    private fun updateListClubScoreCompeting(clubCompeting: List<ClubCompeting>) {
        viewModelScope.launch {

        }
    }

    private fun fetchClubs(){
        viewModelScope.launch {
            repository.getAllScore().collect {
                _stateClubs.value = ClubsUiState(it)
            }
        }
    }

    companion object {
        fun inject() = module {
            viewModelOf(::ScoreViewModel)
        }
    }
}

data class ScoreUiState(val message: String  = "")

data class ClubsUiState(val list: List<ClubInfo> = emptyList())

sealed interface ScoreIntent {
    data class OnUpdateClubScoreCompeting(val clubCompeting: ClubCompeting): ScoreIntent
    data class OnUpdateListClubScoreCompeting(val list: List<ClubCompeting>): ScoreIntent
    object OnFetchClubsInfo: ScoreIntent
}