package com.github.mrvilkaman.crossfitleaderboard.di.mainmodule

import android.support.v7.app.AppCompatActivity
import com.github.mrvilkaman.core.R
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.MainActivity
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.MainNavigator
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard.LeaderboardScreen
import com.github.mrvilkaman.di.INeedActivityViewNotify
import com.github.mrvilkaman.di.PerActivity
import com.github.mrvilkaman.di.PerScreen
import com.github.mrvilkaman.presentationlayer.resolution.drawer.LeftDrawerHelper
import com.github.mrvilkaman.presentationlayer.resolution.toolbar.ToolbarResolver
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap
import ru.terrakok.cicerone.Navigator

@Module
class MainModule {

    @Provides
    @PerActivity
    fun provideNavigator(
            activity: AppCompatActivity,
            toolbarResolver: ToolbarResolver?,
            leftDrawerHelper: LeftDrawerHelper?

    ): Navigator = MainNavigator(activity, R.id.content, toolbarResolver, leftDrawerHelper)

    @Provides
    @IntoMap
    @IntKey(Int.MAX_VALUE)
    @PerActivity
    fun createLeftDrawerHelperINeedActivityViewNotify(helper: Navigator): INeedActivityViewNotify =
            helper as INeedActivityViewNotify
}

@Module
interface MainFragModule {
    @Binds
    @PerActivity
    fun provideFeatureView(featureActivity: MainActivity): AppCompatActivity


    @PerScreen
    @ContributesAndroidInjector()
    fun getLeaderboardScreen(): LeaderboardScreen
}