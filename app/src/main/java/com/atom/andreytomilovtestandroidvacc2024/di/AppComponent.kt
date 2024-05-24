package com.atom.andreytomilovtestandroidvacc2024.di

import android.util.Log
import com.atom.andreytomilovtestandroidvacc2024.ui.dashboard.MenuFragment
import com.atom.andreytomilovtestandroidvacc2024.ui.home.CoffeeDetailFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, DataModule::class, NetworkModule::class, ViewModelModule::class, DomainModule::class])
interface AppComponent {

    fun inject(fragment: MenuFragment) {
        Log.d("AppComponent", "MenuFragment")
    }

    fun inject(fragment: CoffeeDetailFragment) {
        Log.d("AppComponent", "CoffeeDetailFragment")
    }

}