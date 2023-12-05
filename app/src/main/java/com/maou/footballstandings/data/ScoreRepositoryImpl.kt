package com.maou.footballstandings.data

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.maou.footballstandings.model.ClubCompeting
import com.maou.footballstandings.model.ClubInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ScoreRepositoryImpl (private val context: Context) : ScoreRepository {

    private val sharedPreferences =
        context.getSharedPreferences("App_Shared_Prefs", Context.MODE_PRIVATE)

    override fun saveClubInfo(club: ClubInfo): Flow<String> {
        return flow {
            val currentClub = sharedPreferences.getString(club.name, null)
            if(currentClub != null) {
                val clubInfo = Gson().fromJson(currentClub, ClubInfo::class.java)
                Log.d("Repos", (clubInfo.name == club.name).toString())

                if(clubInfo.name == club.name)
                    emit("Club already exist")
            } else {
                val clubJson = Gson().toJson(club)
                sharedPreferences.edit().putString(club.name, clubJson).apply()
                emit("Saved")
            }

        }
    }

    override fun updateClubScore(club: ClubCompeting): Flow<String> {
        return flow {
            val club1 = sharedPreferences.getString(club.club1.name, null)
            val club2 = sharedPreferences.getString(club.club2.name, null)

            if(club1 ==null || club2 == null) {
                emit("Club name is not exist")
            } else {
                val clubInfo1 = Gson().fromJson(club1, ClubInfo::class.java)
                val clubInfo2 = Gson().fromJson(club2, ClubInfo::class.java)

                Log.d("Club1", clubInfo1.toString())
                Log.d("Club2", clubInfo2.toString())

                val clubInfoUpdated1 = club.club1.apply {
                    ClubInfo(
                        name = name,
                        playing = (playing+clubInfo1.playing),
                        city = city,
                        draw = (draw+clubInfo1.draw),
                        point = (point+clubInfo1.point),
                        win = (win+clubInfo1.win),
                        winGoal = (winGoal+clubInfo1.winGoal),
                        lose = (lose+clubInfo1.lose),
                        loseGoal = (loseGoal+clubInfo1.loseGoal),
                    )
                }

                val clubInfoUpdated2 = club.club2.apply {
                    ClubInfo(
                        name = name,
                        playing = (playing+clubInfo2.playing),
                        city = city,
                        draw = (draw+clubInfo2.draw),
                        point = (point+clubInfo2.point),
                        win = (win+clubInfo2.win),
                        winGoal = (winGoal+clubInfo2.winGoal),
                        lose = (lose+clubInfo2.lose),
                        loseGoal = (loseGoal+clubInfo2.loseGoal),
                    )
                }

                Log.d("Club1", clubInfoUpdated1.toString())
                Log.d("Club2", clubInfoUpdated2.toString())

                val clubUpdatedJson1 = Gson().toJson(clubInfoUpdated1)
                val clubUpdatedJson2 = Gson().toJson(clubInfoUpdated2)
                sharedPreferences.edit().putString(clubInfoUpdated1.name, clubUpdatedJson1).apply()
                sharedPreferences.edit().putString(clubInfoUpdated2.name, clubUpdatedJson2).apply()

                emit("Updated")
            }
        }
    }

    override fun updateListClubScore(clubScores: List<ClubCompeting>): Flow<String> {
        return flow {
            for (club in clubScores) {
                val club1 = sharedPreferences.getString(club.club1.name, null)
                val club2 = sharedPreferences.getString(club.club2.name, null)

                if(club1 ==null || club2 == null) {
                    emit("Club name is not exist")
                } else {
                    val clubInfo1 = Gson().fromJson(club1, ClubInfo::class.java)
                    val clubInfo2 = Gson().fromJson(club2, ClubInfo::class.java)

                    val clubInfoUpdated1 = club.club1.apply {
                        ClubInfo(
                            name = name,
                            playing = playing.plus(clubInfo1.playing),
                            city = city,
                            draw = draw.plus(clubInfo1.draw),
                            point = point.plus(clubInfo1.point),
                            win = win.plus(clubInfo1.win),
                            winGoal = winGoal.plus(clubInfo1.winGoal),
                            lose = lose.plus(clubInfo1.lose),
                            loseGoal = loseGoal.plus(clubInfo1.loseGoal),
                        )
                    }

                    val clubInfoUpdated2 = club.club2.apply {
                        ClubInfo(
                            name = name,
                            playing = playing.plus(clubInfo2.playing),
                            city = city,
                            draw = draw.plus(clubInfo2.draw),
                            point = point.plus(clubInfo2.point),
                            win = win.plus(clubInfo2.win),
                            winGoal = winGoal.plus(clubInfo2.winGoal),
                            lose = lose.plus(clubInfo2.lose),
                            loseGoal = loseGoal.plus(clubInfo2.loseGoal),
                        )
                    }



                    val clubUpdatedJson1 = Gson().toJson(clubInfoUpdated1)
                    val clubUpdatedJson2 = Gson().toJson(clubInfoUpdated2)
                    sharedPreferences.edit().putString(clubInfoUpdated1.name, clubUpdatedJson1).apply()
                    sharedPreferences.edit().putString(clubInfoUpdated2.name, clubUpdatedJson2).apply()

                    emit("Updated")
                }
            }
        }
    }

    override fun getAllScore(): Flow<List<ClubInfo>> {
        return flow {
            val entryValues = sharedPreferences.all
            val scores = arrayListOf<ClubInfo>()
            for (entry in entryValues) {
                val clubJson = Gson().fromJson(entry.value.toString(), ClubInfo::class.java)
                scores.add(clubJson)
            }

            emit(scores)
        }
    }
}