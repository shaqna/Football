package com.maou.footballstandings.data.di

import com.maou.footballstandings.data.ScoreRepository
import com.maou.footballstandings.data.ScoreRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::ScoreRepositoryImpl) {
        bind<ScoreRepository>()
    }
}