package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.ScreensKey.*
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.MainActivity
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo.MainInfoWizardScreen
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.teaminfo.TeamInfoWizardScreenFragment
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo.WodInfoWizardScreen
import com.github.mrvilkaman.presentationlayer.resolution.BaseNavigator
import com.github.mrvilkaman.presentationlayer.resolution.drawer.LeftDrawerHelper
import com.github.mrvilkaman.presentationlayer.resolution.toolbar.ToolbarResolver


class RegistrationNavigator(
        private val activity: AppCompatActivity,
        containerId: Int,
        toolbarResolver: ToolbarResolver?,
        leftDrawerHelper: LeftDrawerHelper?
) :
        BaseNavigator(activity, containerId, toolbarResolver, leftDrawerHelper) {


    @Suppress("WhenWithOnlyElse", "UNUSED_EXPRESSION")
    override fun createActivityIntent(screenKey: String, data: Any?): Intent? = when (screenKey) {
        EVENT_SCREEN -> Intent(activity,MainActivity::class.java)
        else -> null
    }

    override fun getDrawer(): Fragment? = null

    override fun getMainScreenKey(): String? =
//            WOD_INFO_REGISTRATION_WIZARD
            MAIN_INFO_REGISTRATION_WIZARD

    override fun createFragment(screenKey: String, data: Any?): Fragment? =
            when (screenKey) {
                MAIN_INFO_REGISTRATION_WIZARD -> MainInfoWizardScreen()
                WOD_INFO_REGISTRATION_WIZARD -> WodInfoWizardScreen.open()
                TEAM_INFO_REGISTRATION_WIZARD -> TeamInfoWizardScreenFragment.open()
                else -> null
            }

}