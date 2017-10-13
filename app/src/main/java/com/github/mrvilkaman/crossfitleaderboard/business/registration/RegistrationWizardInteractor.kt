package com.github.mrvilkaman.crossfitleaderboard.business.registration

import com.github.mrvilkaman.crossfitleaderboard.R
import io.reactivex.Completable
import java.util.*
import javax.inject.Inject


interface RegistrationWizardInteractor {
    fun validateMainEventInfo(title: String, date: Date?, wodCount: Int?): Completable
}

class RegistrationWizardInteractorImpl
@Inject constructor()
    : RegistrationWizardInteractor {

    override fun validateMainEventInfo(title: String, date: Date?, wodCount: Int?): Completable {
        if (title.isEmpty()) {
            return Completable.error(ValidateException(R.string.registration_wizard_error_title_empty))
        }
        if (date == null) {
            return Completable.error(ValidateException(R.string.registration_wizard_error_date_empty))
        }
        if (wodCount == null) {
            return Completable.error(ValidateException(R.string.registration_wizard_error))
        }
        return Completable.complete()

    }

}