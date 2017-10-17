package com.github.mrvilkaman.crossfitleaderboard.repository

import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitEvent


interface EventsRepo {
    var currentEvent: CrossfitEvent?
}