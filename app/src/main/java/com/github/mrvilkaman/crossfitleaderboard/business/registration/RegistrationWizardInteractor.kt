package com.github.mrvilkaman.crossfitleaderboard.business.registration

import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitEvent
import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitResult
import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitTeam
import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitWod
import com.github.mrvilkaman.crossfitleaderboard.repository.EventBuilderRepo
import com.github.mrvilkaman.crossfitleaderboard.repository.EventsRepo
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
        private val eventBuilderRepo: EventBuilderRepo,
        private val eventsRepo: EventsRepo
)
    : RegistrationWizardInteractor {
    
    override fun validateTeamInfoAndCreateEvent(): Completable = validateTeamInfo().andThen(saveNewEvent())

    fun validateTeamInfo(): Completable = Completable.complete()

    fun saveNewEvent():Completable{
        val infoUIModel = eventBuilderRepo.regEventMainInfoUIModel!!
        val wodsCrossfit = ArrayList<CrossfitWod>()
        eventBuilderRepo.wods.forEachIndexed { index, it ->
            val results = arrayListOf(
                    CrossfitResult(CrossfitTeam("Username 1")),
                    CrossfitResult(CrossfitTeam("Username 2")),
                    CrossfitResult(CrossfitTeam("Username 3"))
            )
            wodsCrossfit.add(CrossfitWod(index+1,it.description, results,it.type))
        }

        eventsRepo.currentEvent = CrossfitEvent(infoUIModel.title!!,infoUIModel.date!!, wodsCrossfit)
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