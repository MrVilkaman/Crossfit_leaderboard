package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.teaminfo


import com.github.mrvilkaman.crossfitleaderboard.ui.screen.ScreensKey
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import ru.terrakok.cicerone.Router

import javax.inject.Inject

class TeamInfoWizardPresenter @Inject
constructor(
        private val router: Router
) : BasePresenter<TeamInfoWizardView>(){
    fun onClickFinish() {
        router.newRootScreen(ScreensKey.EVENT_SCREEN)
    }

}
