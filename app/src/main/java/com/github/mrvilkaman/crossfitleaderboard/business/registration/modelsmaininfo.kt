package com.github.mrvilkaman.crossfitleaderboard.business.registration

import android.os.Bundle
import android.support.annotation.StringRes
import com.github.mrvilkaman.di.PerScreen
import java.util.*
import javax.inject.Inject


data class ValidateException(@StringRes val errorMessageTextId: Int = 0,val number:Int = 0) : Throwable() {
    override fun fillInStackTrace(): Throwable = this
}

data class ValidateCompositeException(val list:List<ValidateException>): Throwable() {
    override fun fillInStackTrace(): Throwable = this
}

@PerScreen
class RegEventMainInfoUIModel @Inject constructor() {
    var title: String? = null
    var date: Date? = null
    var wodCount: Int? = null

    companion object {
        private val KEY_TITLE = "title"
        private val KEY_WOD_COUNT = "wodCount"
        private val KEY_DATE = "date"
    }


    fun onStateRestored(savedInstanceState: Bundle?) {
        if (savedInstanceState == null)
            return
        title = savedInstanceState.getString(KEY_TITLE)
        wodCount = savedInstanceState.getInt(KEY_WOD_COUNT)
        val long: Long? = savedInstanceState.getLong(KEY_DATE)
        if (long != null)
            date = Date(long)

    }

    fun onSaveState(outState: Bundle?) {
        if (outState != null) {
            outState.putString(KEY_TITLE, title)
            val wodCount1 = wodCount
            if (wodCount1 != null)
                outState.putInt(KEY_WOD_COUNT, wodCount1)

            val date1 = date
            if (date1 != null)
                outState.putLong(KEY_DATE, date1.time)
        }
    }
}