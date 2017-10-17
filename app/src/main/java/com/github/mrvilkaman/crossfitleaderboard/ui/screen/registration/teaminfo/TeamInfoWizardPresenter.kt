package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.teaminfo


import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegistrationWizardInteractor
import com.github.mrvilkaman.crossfitleaderboard.business.registration.ValidateCompositeException
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.ScreensKey
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.subscriber.ViewSubscriber
import ru.terrakok.cicerone.Router

import javax.inject.Inject

class TeamInfoWizardPresenter @Inject
constructor(
        private val interactor: RegistrationWizardInteractor,
        private val router: Router
) : BasePresenter<TeamInfoWizardView>() {

    fun onClickFinish() {
        subscribeUI(interactor.validateTeamInfoAndCreateEvent(), ValidateSubs(router))
    }
}

private class ValidateSubs(val router: Router) : ViewSubscriber<TeamInfoWizardView, Void>() {
    override fun onComplete() {
        super.onComplete()
        router.newRootScreen(ScreensKey.EVENT_SCREEN)
    }

    override fun onError(e: Throwable) {
        if (e is ValidateCompositeException) {
            e.list.forEach {
                view().showTeamErrors(it.errorMessageTextId, it.number)
            }
            skipNextError()
        }
        super.onError(e)
    }

}
