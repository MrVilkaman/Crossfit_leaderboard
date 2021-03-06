package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard


import com.github.mrvilkaman.crossfitleaderboard.repository.EventsRepo
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import javax.inject.Inject

class LeaderboardPresenter @Inject
constructor(
    private val eventsRepo: EventsRepo
) : BasePresenter<LeaderboardView>() {

    override fun onViewAttached() {
        super.onViewAttached()
        val currentEvent = eventsRepo.currentEvent!!
        view().bindWods(currentEvent.wods)
    }
}
