package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo


import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment

class WodInfoWizardScreen : BaseFragment<WodInfoWizardPresenter>(), WodInfoWizardView {

    override fun getLayoutId(): Int = R.layout.fragment_layout_wodinfoscreen_wizard

    companion object {
        fun open(): WodInfoWizardScreen = WodInfoWizardScreen()
    }

}