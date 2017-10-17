package com.github.mrvilkaman.crossfitleaderboard.di.app


import com.github.mrvilkaman.crossfitleaderboard.di.mainmodule.MainFragModule
import com.github.mrvilkaman.crossfitleaderboard.di.mainmodule.MainModule
import com.github.mrvilkaman.crossfitleaderboard.di.regmodule.RegistrationFragModule
import com.github.mrvilkaman.crossfitleaderboard.di.regmodule.RegistrationModule
import com.github.mrvilkaman.crossfitleaderboard.ui.app.App
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.MainActivity
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.RegistrationActivity
import com.github.mrvilkaman.di.PerActivity
import com.github.mrvilkaman.di.modules.CoreProvidersModule
import com.github.mrvilkaman.di.modules.DevModule
import com.github.mrvilkaman.di.modules.EventBusModule
import com.github.mrvilkaman.di.modules.activity.CommonActivityModule
import com.github.mrvilkaman.di.modules.activity.DrawerEmptyModule
import com.github.mrvilkaman.di.modules.activity.ThrowableModule
import com.github.mrvilkaman.di.modules.activity.ToolbarModule
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Component(modules = arrayOf(
        AppModule::class,
        DevModule::class,
        EventBusModule::class,
        CoreProvidersModule::class,
        AppRepoModules::class,
        NavigationModule::class))
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
}

@Module
class NavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.navigatorHolder
}

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
interface AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
            CommonActivityModule::class,
            ThrowableModule::class,
            RegistrationModule::class,
            ToolbarModule::class,
            DrawerEmptyModule::class,
            RegistrationFragModule::class
    ))
    fun registrationInjector(): RegistrationActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
            CommonActivityModule::class,
            ThrowableModule::class,
            MainModule::class,
            MainFragModule::class,
            ToolbarModule::class,
            DrawerEmptyModule::class
    ))
    fun mainInjector(): MainActivity
}

