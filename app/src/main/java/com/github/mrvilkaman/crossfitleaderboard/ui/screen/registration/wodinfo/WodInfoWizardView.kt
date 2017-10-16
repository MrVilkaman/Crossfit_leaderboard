package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo

import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseView


interface WodInfoWizardView : BaseView {
    fun createWodViews(wods: List<WodItem>)
    fun showWodError(errorMessageTextId: Int, number: Int)
}