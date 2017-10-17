package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard

import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitWod
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseView


interface LeaderboardView : BaseView {

    fun bindWods(list: List<CrossfitWod>)
}