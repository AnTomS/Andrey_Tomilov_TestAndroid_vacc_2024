package com.atom.andreytomilovtestandroidvacc2024.di

import android.util.Log
import com.atom.andreytomilovtestandroidvacc2024.MainActivity
import com.atom.andreytomilovtestandroidvacc2024.ui.menu.MenuFragment
import com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail.CoffeeDetailFragment
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

    fun inject(activity: MainActivity) {
        Log.d("AppComponent", "Injecting MainActivity")
    }

}