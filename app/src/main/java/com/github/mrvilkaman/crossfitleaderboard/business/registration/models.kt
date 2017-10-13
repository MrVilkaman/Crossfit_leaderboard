package com.github.mrvilkaman.crossfitleaderboard.business.registration

import android.support.annotation.StringRes


class ValidateException(@StringRes val errorMessageTextId: Int) : Throwable() {

    override fun fillInStackTrace(): Throwable = this
}