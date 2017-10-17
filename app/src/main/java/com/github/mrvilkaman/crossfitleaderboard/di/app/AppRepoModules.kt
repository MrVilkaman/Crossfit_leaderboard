package com.github.mrvilkaman.crossfitleaderboard.di.app

import com.github.mrvilkaman.crossfitleaderboard.data.registration.EventsRepoStub
import com.github.mrvilkaman.crossfitleaderboard.repository.EventsRepo
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class AppRepoModules {
    @Singleton
    @Binds
//    abstract fun provideEventsRepo(repo: EventsRepoImpl): EventsRepo
    abstract fun provideEventsRepo(repo: EventsRepoStub): EventsRepo
}