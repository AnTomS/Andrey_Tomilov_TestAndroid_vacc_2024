package com.atom.andreytomilovtestandroidvacc2024.di

import com.atom.andreytomilovtestandroidvacc2024.data.repository.RepositoryImpl
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetAllCoffeeListUseCase
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetCoffeeDetailUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideRegisterUseCase(repository: RepositoryImpl): GetAllCoffeeListUseCase {
        return GetAllCoffeeListUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideLoginUseCase(repository: RepositoryImpl): GetCoffeeDetailUseCase {
        return GetCoffeeDetailUseCase(repository)
    }


}