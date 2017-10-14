package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo

import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegistrationWizardInteractor
import com.github.mrvilkaman.crossfitleaderboard.business.registration.ValidateCompositeException
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.ScreensKey
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.subscriber.ViewSubscriber
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class WodInfoWizardPresenter @Inject
constructor(
        private val interactor: RegistrationWizardInteractor,
        private val router: Router
) : BasePresenter<WodInfoWizardView>() {

    override fun onViewAttached() {
        subscribeUI(interactor.initWodCount(), WodCountInitSubs())
    }

    fun onClickNextStep(array: ArrayList<WodItem>) {
        subscribeUI(interactor.validateWodInfo(array), ValidateSubs(router))
    }
}


private class WodCountInitSubs() : ViewSubscriber<WodInfoWizardView, Int>() {
    override fun onNext(wodCount: Int) {
        super.onNext(wodCount)
        view().createWodViews(wodCount)
    }
}

private class ValidateSubs(val router: Router) : ViewSubscriber<WodInfoWizardView, Void>() {
    override fun onComplete() {
        super.onComplete()
        router.navigateTo(ScreensKey.TEAM_INFO_REGISTRATION_WIZARD)
    }

    override fun onError(e: Throwable) {
        if (e is ValidateCompositeException) {
            e.list.forEach {
                view().showWodError(it.errorMessageTextId, it.number)
            }
            skipNextError()
        }
        super.onError(e)
    }

}


