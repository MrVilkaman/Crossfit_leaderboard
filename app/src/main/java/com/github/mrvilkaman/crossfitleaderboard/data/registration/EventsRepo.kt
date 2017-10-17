package com.github.mrvilkaman.crossfitleaderboard.data.registration

import com.github.mrvilkaman.crossfitleaderboard.business.*
import com.github.mrvilkaman.crossfitleaderboard.repository.EventsRepo
import java.util.*
import javax.inject.Inject


class EventsRepoImpl @Inject
constructor() : EventsRepo {
    override var currentEvent: CrossfitEvent? = null
//        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
//        set(value) {}
}


class EventsRepoStub @Inject
constructor() : EventsRepo {
    override var currentEvent: CrossfitEvent? = null
        get() {
            val results = arrayListOf(
                    CrossfitResult(CrossfitTeam("Username 1")),
                    CrossfitResult(CrossfitTeam("Username 2")),
                    CrossfitResult(CrossfitTeam("Username 3"))
            )
            val results2 = arrayListOf(
                    CrossfitResult(CrossfitTeam("Username 1")),
                    CrossfitResult(CrossfitTeam("Username 2")),
                    CrossfitResult(CrossfitTeam("Username 3"))
            )
            val wodsCrossfit = arrayListOf(
                    CrossfitWod(1, "Бурпи и еще раз бурпи", results, WodType.AMRAP),
                    CrossfitWod(2, "21-15-9\nТрастеры\nБурпи", results2, WodType.AFAP)
            )

            return CrossfitEvent("Заголовок!", Date(), wodsCrossfit)
        }
}