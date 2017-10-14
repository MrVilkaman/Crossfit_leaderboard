package com.github.mrvilkaman.crossfitleaderboard.business.registration

import android.support.annotation.StringRes
import com.github.mrvilkaman.crossfitleaderboard.R


enum class WodType(@StringRes val titleStrId: Int) {
    AFAP(R.string.wod_wizard_type_afar),
    AMRAP(R.string.wod_wizard_type_amrap)
}