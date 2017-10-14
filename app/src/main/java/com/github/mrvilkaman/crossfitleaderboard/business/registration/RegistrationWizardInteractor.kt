package com.github.mrvilkaman.crossfitleaderboard.business.registration

import com.github.mrvilkaman.crossfitleaderboard.R
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


interface RegistrationWizardInteractor {
    fun validateMainEventInfo(uiModel: RegEventMainInfoUIModel): Completable
    fun initWodCount(): Single<Int>
}

class RegistrationWizardInteractorImpl
@Inject constructor()
    : RegistrationWizardInteractor {

    override fun initWodCount(): Single<Int> = Single.just(3)

    override fun validateMainEventInfo(uiModel: RegEventMainInfoUIModel): Completable {
        if (uiModel.title.isNullOrEmpty()) {
            return Completable.error(ValidateException(R.string.registration_wizard_error_title_empty))
        }
        if (uiModel.date == null) {
            return Completable.error(ValidateException(R.string.registration_wizard_error_date_empty))
        }
        if (uiModel.wodCount == null) {
            return Completable.error(ValidateException(R.string.registration_wizard_error))
        }
        return Completable.complete()

    }

}