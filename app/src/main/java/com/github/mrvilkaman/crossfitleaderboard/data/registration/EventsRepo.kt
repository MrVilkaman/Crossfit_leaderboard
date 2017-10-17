package com.github.mrvilkaman.crossfitleaderboard.data.registration

import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitEvent
import com.github.mrvilkaman.crossfitleaderboard.repository.EventsRepo
import javax.inject.Inject


class EventsRepoImpl @Inject
constructor() : EventsRepo {
    override var currentEvent: CrossfitEvent? = null
//        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
//        set(value) {}
}