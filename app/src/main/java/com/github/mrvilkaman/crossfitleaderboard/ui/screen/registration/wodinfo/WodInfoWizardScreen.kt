package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo


import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment

class WodInfoWizardScreen : BaseFragment<WodInfoWizardPresenter>(), WodInfoWizardView {

    override fun getLayoutId(): Int = R.layout.layout_wodinfoscreen_fragment

    companion object {
        fun open(): WodInfoWizardScreen = WodInfoWizardScreen()
    }

}