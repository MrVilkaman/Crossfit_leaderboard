package com.github.mrvilkaman.crossfitleaderboard.data.registration

import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegEventMainInfoUIModel
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodType
import com.github.mrvilkaman.crossfitleaderboard.repository.EventBuilderRepo
import javax.inject.Inject


class EventBuilderRepoImpl @Inject
constructor() : EventBuilderRepo {
    override var regEventMainInfoUIModel: RegEventMainInfoUIModel? = null
        set(value) {
            val wodCount = value?.wodCount
            if (wodCount != null) {
                val list = wods as ArrayList<WodItem>
                val diff = wodCount - list.size
                wods = when {
                    diff < 0 -> ArrayList(list.subList(0, wodCount))
                    diff > 0 -> {
                        (0 until diff).forEach {
                            list.add(WodItem("", WodType.AFAP))
                        }
                        list
                    }
                    else -> list
                }
            }
        }
    override var wods: List<WodItem> = ArrayList()

    override fun wodsFinish() {

    }

    override fun mainInfoFinish() {
    }
}