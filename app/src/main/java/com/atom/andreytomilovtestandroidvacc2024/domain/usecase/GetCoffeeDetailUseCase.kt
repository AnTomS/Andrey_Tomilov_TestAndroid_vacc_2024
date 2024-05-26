package com.atom.andreytomilovtestandroidvacc2024.domain.usecase

import com.atom.andreytomilovtestandroidvacc2024.data.repository.RepositoryImpl
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee

class GetCoffeeDetailUseCase(private val repository: RepositoryImpl) {
    suspend operator fun invoke(coffeeId: Int): Coffee {
        return repository.getCoffeeDetail(coffeeId)
    }
}