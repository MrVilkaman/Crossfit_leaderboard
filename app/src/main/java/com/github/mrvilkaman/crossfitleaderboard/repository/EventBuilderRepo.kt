package com.github.mrvilkaman.crossfitleaderboard.repository

import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegEventMainInfoUIModel
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem


interface EventBuilderRepo {
    var regEventMainInfoUIModel: RegEventMainInfoUIModel?
    var wods: List<WodItem>

    fun wodsFinish()
    fun mainInfoFinish()
}