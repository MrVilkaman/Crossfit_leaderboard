package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo

import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegistrationWizardInteractor
import com.github.mrvilkaman.crossfitleaderboard.business.registration.ValidateException
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.ScreensKey
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo.MainInfoWizardView
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.subscriber.ViewSubscriber
import ru.terrakok.cicerone.Router
import javax.inject.Inject


class WodInfoWizardPresenter @Inject
constructor(
        private val interactor: RegistrationWizardInteractor
) : BasePresenter<WodInfoWizardView>() {

    override fun onViewAttached() {
        subscribeUI(interactor.initWodCount(), WodCountInitSubs())
    }
}


private class WodCountInitSubs() : ViewSubscriber<WodInfoWizardView, Int>() {
    override fun onNext(wodCount: Int) {
        super.onNext(wodCount)
        view().createWodViews(wodCount)
    }
}
