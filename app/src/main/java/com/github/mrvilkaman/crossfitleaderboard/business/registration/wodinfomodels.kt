package com.github.mrvilkaman.crossfitleaderboard.business.registration

import com.github.mrvilkaman.crossfitleaderboard.business.WodType


data class WodItem(
        val description: String,
        val type: WodType
)