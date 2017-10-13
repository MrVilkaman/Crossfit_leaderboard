package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo

import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import java.util.*
import javax.inject.Inject


class MainInfoWizardPresenter @Inject
constructor() : BasePresenter<MainInfoWizardView>() {
    fun onDateChanged(date: Date) {
        view().bindDate(date)
    }

    fun onWodCountChanged(wodCountStr: String) {
        val wodCount = wodCountStr.toInt()
    }
}
