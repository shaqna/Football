package com.maou.footballstandings.data

import com.maou.footballstandings.model.ClubCompeting
import com.maou.footballstandings.model.ClubInfo
import kotlinx.coroutines.flow.Flow

interface ScoreRepository {
    fun saveClubInfo(club: ClubInfo): Flow<String>
    fun updateClubScore(score: ClubCompeting): Flow<String>
    fun updateListClubScore(clubScores: List<ClubCompeting>): Flow<String>
    fun getAllScore(): Flow<List<ClubInfo>>
}