package com.github.mrvilkaman.crossfitleaderboard.business.registration

import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.repository.EventBuilderRepo
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject


interface RegistrationWizardInteractor {
    fun validateMainEventInfo(uiModel: RegEventMainInfoUIModel): Completable
    fun validateWodInfo(wods: List<WodItem>): Completable
    fun validateTeamInfoAndCreateEvent(): Completable

    fun createWods(): Single<List<WodItem>>
}

class RegistrationWizardInteractorImpl
@Inject constructor(
        private val eventBuilderRepo: EventBuilderRepo
)
    : RegistrationWizardInteractor {
    
    override fun validateTeamInfoAndCreateEvent(): Completable = validateTeamInfo().andThen(saveNewEvent())

    fun validateTeamInfo(): Completable = Completable.complete()

    fun saveNewEvent():Completable{

        return Completable.complete()
    }



    override fun createWods(): Single<List<WodItem>> = Single.just(eventBuilderRepo.wods)

    override fun validateMainEventInfo(uiModel: RegEventMainInfoUIModel): Completable {
        eventBuilderRepo.regEventMainInfoUIModel = uiModel
        if (uiModel.title.isNullOrEmpty()) {
            return Completable.error(ValidateException(R.string.registration_wizard_error_title_empty))
        }
        if (uiModel.date == null) {
            return Completable.error(ValidateException(R.string.registration_wizard_error_date_empty))
        }
        if (uiModel.wodCount == null) {
            return Completable.error(ValidateException(R.string.registration_wizard_error))
        }
        eventBuilderRepo.mainInfoFinish()
        return Completable.complete()
    }

    override fun validateWodInfo(wods: List<WodItem>): Completable {
        eventBuilderRepo.wods = wods

        val list = ArrayList<ValidateException>()
        wods.forEachIndexed { index, wodItem ->
            if (wodItem.description.isEmpty()) {
                list.add(ValidateException(R.string.registration_wizard_error_description_empty, index))
            }
        }
        if (list.isNotEmpty()) {
            return Completable.error(ValidateCompositeException(list))
        }
        eventBuilderRepo.wodsFinish()

        return Completable.complete()
    }
}