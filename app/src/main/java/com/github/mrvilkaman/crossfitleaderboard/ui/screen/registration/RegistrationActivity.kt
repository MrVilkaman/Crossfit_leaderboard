package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration


import com.github.mrvilkaman.core.R
import com.github.mrvilkaman.presentationlayer.activities.BaseActivity
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter


class RegistrationActivity : BaseActivity<BasePresenter<*>>() {

    override fun afterOnCreate() {
    }

    override fun getActivityLayoutResourceID(): Int = R.layout.cleanbase_activity_content_only
}
