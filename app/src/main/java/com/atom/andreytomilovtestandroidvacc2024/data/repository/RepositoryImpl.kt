package com.atom.andreytomilovtestandroidvacc2024.data.repository

import com.atom.andreytomilovtestandroidvacc2024.data.network.ApiService
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.atom.andreytomilovtestandroidvacc2024.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {
    override suspend fun getCoffees(): List<Coffee> =
        apiService.getCoffeeList()


    override suspend fun getCoffeeDetail(id: Int): Coffee {
        TODO("Not yet implemented")
    }
}