package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo

import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.registration.RegistrationWizardInteractor
import com.github.mrvilkaman.crossfitleaderboard.business.registration.ValidateException
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.subscriber.ViewSubscriber
import java.util.*
import javax.inject.Inject


class MainInfoWizardPresenter @Inject
constructor(
        private val interactor: RegistrationWizardInteractor

) : BasePresenter<MainInfoWizardView>() {

    private var date:Date? = null
    private var wodCount:Int? = null

    fun onDateChanged(date: Date) {
        view().bindDate(date)
        this.date = date
    }

    fun onWodCountChanged(wodCountStr: String) {
        wodCount = wodCountStr.toInt()
    }

    fun onClickNextStep(title: String) {
        subscribeUI(interactor.validateMainEventInfo(
                title,
                date,
                wodCount
        ), ValidateSubs())
    }
}


private class ValidateSubs:ViewSubscriber<MainInfoWizardView,Void>(){
    override fun onComplete() {
        super.onComplete()
        uiResolver.showToast(R.string.cleanbase_simple_text,"cool!")
    }

    override fun onError(e: Throwable) {
        if (e is ValidateException) {
            uiResolver.showToast(e.errorMessageTextId)
            skipNextError()
        }

        super.onError(e)
    }
}