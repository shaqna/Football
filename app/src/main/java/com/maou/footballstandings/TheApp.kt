package com.maou.footballstandings

import android.app.Application
import com.maou.footballstandings.data.di.dataModule
import com.maou.footballstandings.presentation.screens.club.ClubViewModel
import com.maou.footballstandings.presentation.screens.score.ScoreViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class TheApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TheApp)
            loadKoinModules(
                listOf(
                    dataModule,
                    ClubViewModel.inject(),
                    ScoreViewModel.inject()
                )
            )

        }
    }
}