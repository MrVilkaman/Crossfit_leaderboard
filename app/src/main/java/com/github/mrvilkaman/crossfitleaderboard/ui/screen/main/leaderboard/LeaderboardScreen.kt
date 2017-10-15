package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard


import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment

class LeaderboardScreen : BaseFragment<LeaderboardPresenter>(), LeaderboardView {

    override fun getLayoutId(): Int = R.layout.fragment_main_leaderboardscreen

    companion object {

        fun open(): LeaderboardScreen = LeaderboardScreen()
    }
}