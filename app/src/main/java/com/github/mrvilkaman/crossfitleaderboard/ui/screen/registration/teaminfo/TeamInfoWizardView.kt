package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.teaminfo


import com.github.mrvilkaman.presentationlayer.fragments.core.BaseView

interface TeamInfoWizardView : BaseView {
    fun showTeamErrors(errorMessageTextId: Int, number: Int)
}