package com.atom.andreytomilovtestandroidvacc2024

import android.app.Application
import android.util.Log
import com.atom.andreytomilovtestandroidvacc2024.di.AppComponent
import com.atom.andreytomilovtestandroidvacc2024.di.AppModule
import com.atom.andreytomilovtestandroidvacc2024.di.DataModule
import com.atom.andreytomilovtestandroidvacc2024.di.NetworkModule
import com.atom.andreytomilovtestandroidvacc2024.di.ViewModelModule
import dagger.android.support.DaggerAppCompatActivity

class App : Application() {

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .dataModule(DataModule(this))
            .viewModelModule(ViewModelModule())
            .networkModule(NetworkModule())
            .build()

        Log.d("App", "AppComponent initialized: $appComponent")
    }
}
