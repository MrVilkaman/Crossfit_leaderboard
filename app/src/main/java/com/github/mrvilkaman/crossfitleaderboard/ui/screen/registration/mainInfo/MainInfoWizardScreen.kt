package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo

import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment


class MainInfoWizardScreen : BaseFragment<MainInfoWizardPresenter>(), MainInfoWizardView {
    override fun getLayoutId(): Int = R.layout.fragment_main_info_registration_wizard
}