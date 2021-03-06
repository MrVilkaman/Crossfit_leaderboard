package com.github.mrvilkaman.crossfitleaderboard.business

import android.support.annotation.StringRes
import com.github.mrvilkaman.crossfitleaderboard.R
import java.util.*


data class CrossfitEvent(
        val title: String,
        val data: Date,
        val wods: List<CrossfitWod>
)

data class CrossfitWod(
        val number: Int,
        val description: String,
        val results: List<CrossfitResult>,
        val type: WodType,
        var state: WodState = WodState.INACTIVE
)

data class CrossfitTeam(
        val name: String
)

data class CrossfitResult(
        val team: CrossfitTeam,
//        val parent: CrossfitWod, // ?
        var score: Int? = null,
        var wodPosition: Int? = null
)

enum class WodType(@StringRes val titleStrId: Int) {
    AFAP(R.string.wod_wizard_type_afar),
    AMRAP(R.string.wod_wizard_type_amrap)
}


enum class WodState {
    INACTIVE, ACTIVE, DONE, FINISH
}
