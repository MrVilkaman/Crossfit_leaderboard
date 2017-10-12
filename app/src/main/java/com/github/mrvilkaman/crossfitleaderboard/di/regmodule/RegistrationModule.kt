package com.github.mrvilkaman.crossfitleaderboard.di.regmodule

import android.support.v7.app.AppCompatActivity
import com.github.mrvilkaman.core.R
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.RegistrationNavigator
import com.github.mrvilkaman.di.INeedActivityViewNotify
import com.github.mrvilkaman.di.PerActivity
import com.github.mrvilkaman.presentationlayer.resolution.drawer.LeftDrawerHelper
import com.github.mrvilkaman.presentationlayer.resolution.toolbar.ToolbarResolver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import ru.terrakok.cicerone.Navigator


@Module
class RegistrationModule {


    @Provides
    @PerActivity
    fun provideMainNavigator(
            activity: AppCompatActivity,
            toolbarResolver: ToolbarResolver?,
            leftDrawerHelper: LeftDrawerHelper?

    ): Navigator = RegistrationNavigator(activity, R.id.content, toolbarResolver, leftDrawerHelper)

    @Provides
    @IntoMap
    @IntKey(Int.MAX_VALUE)
    @PerActivity
    fun createLeftDrawerHelperINeedActivityViewNotify(helper: Navigator): INeedActivityViewNotify =
            helper as INeedActivityViewNotify
}