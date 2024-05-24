package com.atom.andreytomilovtestandroidvacc2024.domain.usecase

import com.atom.andreytomilovtestandroidvacc2024.data.network.ResultState
import com.atom.andreytomilovtestandroidvacc2024.data.repository.RepositoryImpl
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee

class GetAllCoffeeListUseCase(private val repository: RepositoryImpl) {
    suspend operator fun invoke(): List<Coffee> {
        return try {
            repository.getCoffees()
        } catch (e: Exception) {
            throw e
        }
    }
}