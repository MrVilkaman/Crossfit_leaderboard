package com.github.mrvilkaman.crossfitleaderboard.business.registration

import com.github.mrvilkaman.crossfitleaderboard.R
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


interface RegistrationWizardInteractor {
    fun validateMainEventInfo(uiModel: RegEventMainInfoUIModel): Completable
    fun validateWodInfo(wods: ArrayList<WodItem>): Completable
    fun initWodCount(): Single<Int>
}

class RegistrationWizardInteractorImpl
@Inject constructor()
    : RegistrationWizardInteractor {

    override fun initWodCount(): Single<Int> = Single.just(uiModel?.wodCount ?: 1)

    private var uiModel: RegEventMainInfoUIModel? = null
    private var wodList: ArrayList<WodItem>? = null

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
        this.uiModel = uiModel
        return Completable.complete()
    }

    override fun validateWodInfo(wods: ArrayList<WodItem>): Completable {
        val list = ArrayList<ValidateException>()
        wods.forEachIndexed { index, wodItem ->
            if (wodItem.description.isEmpty()) {
                list.add(ValidateException(R.string.registration_wizard_error_description_empty, index))
            }
        }
        if (list.isNotEmpty()) {
            return Completable.error(ValidateCompositeException(list))
        }
        wodList = wods
        return Completable.complete()
    }
}