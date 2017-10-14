package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.teaminfo


import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment

class TeamInfoWizardScreenFragment : BaseFragment<TeamInfoWizardPresenter>(), TeamInfoWizardView {

    override fun getLayoutId(): Int {
        return R.layout.layout_teaminfowizardscreen_fragment
    }

    companion object {
        fun open(): TeamInfoWizardScreenFragment {
            return TeamInfoWizardScreenFragment()
        }
    }


}