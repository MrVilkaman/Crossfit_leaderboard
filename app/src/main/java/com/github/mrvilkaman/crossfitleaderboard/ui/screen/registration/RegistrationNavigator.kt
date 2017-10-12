package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.github.mrvilkaman.presentationlayer.resolution.BaseNavigator
import com.github.mrvilkaman.presentationlayer.resolution.drawer.LeftDrawerHelper
import com.github.mrvilkaman.presentationlayer.resolution.toolbar.ToolbarResolver


class RegistrationNavigator(
        activity: AppCompatActivity,
        containerId: Int,
        toolbarResolver: ToolbarResolver?,
        leftDrawerHelper: LeftDrawerHelper?
) :
        BaseNavigator(activity, containerId, toolbarResolver, leftDrawerHelper) {
    override fun createActivityIntent(screenKey: String?, data: Any?): Intent? {
        return null
    }

    override fun getDrawer(): Fragment? {
        return null

    }

    override fun getMainScreenKey(): String? {
        return null

    }

    override fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return null
    }
}