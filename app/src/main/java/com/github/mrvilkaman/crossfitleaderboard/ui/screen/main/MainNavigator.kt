package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.github.mrvilkaman.presentationlayer.resolution.BaseNavigator
import com.github.mrvilkaman.presentationlayer.resolution.drawer.LeftDrawerHelper
import com.github.mrvilkaman.presentationlayer.resolution.toolbar.ToolbarResolver

class MainNavigator(
        activity: AppCompatActivity,
        containerId: Int,
        toolbarResolver: ToolbarResolver?,
        leftDrawerHelper: LeftDrawerHelper?
) :
        BaseNavigator(activity, containerId, toolbarResolver, leftDrawerHelper) {


    @Suppress("WhenWithOnlyElse", "UNUSED_EXPRESSION")
    override fun createActivityIntent(screenKey: String, data: Any?): Intent? = when (screenKey) {
        else -> null
    }

    override fun getDrawer(): Fragment? = null

    override fun getMainScreenKey(): String? =
            null

    override fun createFragment(screenKey: String, data: Any?): Fragment? =
            when (screenKey) {
                else -> null
            }

}