package com.atom.andreytomilovtestandroidvacc2024.domain.usecase

import com.atom.andreytomilovtestandroidvacc2024.data.repository.RepositoryImpl
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee

class GetAllCoffeeListUseCase(private val repository: RepositoryImpl) {
    suspend operator fun invoke(): Result<List<Coffee>> {
        return try {
            Result.success(repository.getCoffees())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}