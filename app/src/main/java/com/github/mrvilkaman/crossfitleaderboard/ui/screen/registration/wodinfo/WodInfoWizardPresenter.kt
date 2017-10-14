package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo

import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegistrationWizardInteractor
import com.github.mrvilkaman.crossfitleaderboard.business.registration.ValidateCompositeException
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.subscriber.ViewSubscriber
import javax.inject.Inject


class WodInfoWizardPresenter @Inject
constructor(
        private val interactor: RegistrationWizardInteractor
) : BasePresenter<WodInfoWizardView>() {

    override fun onViewAttached() {
        subscribeUI(interactor.initWodCount(), WodCountInitSubs())
    }

    fun onClickNextStep(array: ArrayList<WodItem>) {
        subscribeUI(interactor.validateWodInfo(array), WodCountInitSubs())
    }
}


private class WodCountInitSubs() : ViewSubscriber<WodInfoWizardView, Int>() {
    override fun onNext(wodCount: Int) {
        super.onNext(wodCount)
        view().createWodViews(wodCount)
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
