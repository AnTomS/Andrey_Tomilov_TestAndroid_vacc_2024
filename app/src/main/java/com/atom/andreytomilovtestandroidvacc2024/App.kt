package com.atom.andreytomilovtestandroidvacc2024

import android.app.Application
import android.util.Log
import com.atom.andreytomilovtestandroidvacc2024.di.AppComponent
import com.atom.andreytomilovtestandroidvacc2024.di.AppModule
import com.atom.andreytomilovtestandroidvacc2024.di.DaggerAppComponent
import com.atom.andreytomilovtestandroidvacc2024.di.DataModule
import com.atom.andreytomilovtestandroidvacc2024.di.DomainModule
import com.atom.andreytomilovtestandroidvacc2024.di.NetworkModule
import com.atom.andreytomilovtestandroidvacc2024.di.ViewModelModule



class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .domainModule(DomainModule())
            .dataModule(DataModule(this))
            .viewModelModule(ViewModelModule())
            .build()

        Log.d("App", "AppComponent initialized: $appComponent")
    }
}
