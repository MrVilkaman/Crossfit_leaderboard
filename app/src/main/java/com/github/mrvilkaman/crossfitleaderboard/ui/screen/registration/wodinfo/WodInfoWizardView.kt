package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo

import com.github.mrvilkaman.presentationlayer.fragments.core.BaseView


interface WodInfoWizardView : BaseView {
    fun createWodViews(wodCount: Int)
}