package com.github.mrvilkaman.crossfitleaderboard.di.app


import android.support.v7.app.AppCompatActivity
import com.github.mrvilkaman.crossfitleaderboard.di.regmodule.RegistrationModule
import com.github.mrvilkaman.crossfitleaderboard.ui.app.App
import com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.RegistrationActivity
import com.github.mrvilkaman.di.PerActivity
import com.github.mrvilkaman.di.injector.EmptyFragmentInjectorModule
import com.github.mrvilkaman.di.modules.CoreProvidersModule
import com.github.mrvilkaman.di.modules.DevModule
import com.github.mrvilkaman.di.modules.EventBusModule
import com.github.mrvilkaman.di.modules.activity.CommonActivityModule
import com.github.mrvilkaman.di.modules.activity.DrawerEmptyModule
import com.github.mrvilkaman.di.modules.activity.ThrowableModule
import com.github.mrvilkaman.di.modules.activity.ToolbarEmptyModule
import dagger.Binds
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
        NavigationModule::class))
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
}

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
interface  AppModule {

    @Binds
    @PerActivity
    fun provideFeatureView(featureActivity: RegistrationActivity): AppCompatActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(
            CommonActivityModule::class,
            ThrowableModule::class,
            RegistrationModule::class,
            ToolbarEmptyModule::class,
            DrawerEmptyModule::class,
            EmptyFragmentInjectorModule::class
    ))
    fun registrationInjector(): RegistrationActivity
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