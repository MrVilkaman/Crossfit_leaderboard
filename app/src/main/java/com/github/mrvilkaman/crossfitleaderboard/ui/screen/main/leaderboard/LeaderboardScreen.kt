package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard


import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitWod
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_leaderboardscreen.*

class LeaderboardScreen : BaseFragment<LeaderboardPresenter>(), LeaderboardView {

    override fun getLayoutId(): Int = R.layout.fragment_main_leaderboardscreen


    override fun bindWods(list: List<CrossfitWod>) {
        wod_1.bindWod(list.first())
    }

    companion object {
        fun open(): LeaderboardScreen = LeaderboardScreen()
    }
}