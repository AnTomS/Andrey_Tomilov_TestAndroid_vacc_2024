package com.atom.andreytomilovtestandroidvacc2024.di

import androidx.lifecycle.ViewModelProvider
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetAllCoffeeListUseCase
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetCoffeeDetailUseCase
import com.atom.andreytomilovtestandroidvacc2024.ui.ViewModelFactory
import com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail.CoffeeDetailViewModel
import com.atom.andreytomilovtestandroidvacc2024.ui.menu.MenuViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ViewModelModule {
    @Singleton
    @Provides
    fun provideMenuViewModelFactory(
        getAllCoffeeListUseCase: GetAllCoffeeListUseCase,
    ): ViewModelProvider.Factory {
        return ViewModelFactory { MenuViewModel(getAllCoffeeListUseCase) }
    }

    @Singleton
    @Provides
    fun provideCoffeeDetailViewModelFactory(
        getCoffeeDetailUseCase: GetCoffeeDetailUseCase,
    ): ViewModelProvider.Factory {
        return ViewModelFactory { CoffeeDetailViewModel(getCoffeeDetailUseCase) }
    }
}