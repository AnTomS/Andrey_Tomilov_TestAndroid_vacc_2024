package com.atom.andreytomilovtestandroidvacc2024.data.repository

import android.util.Log
import com.atom.andreytomilovtestandroidvacc2024.data.network.ApiService
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.atom.andreytomilovtestandroidvacc2024.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {

    private var coffeeList: List<Coffee>? = null

    override suspend fun getCoffees(): List<Coffee> {
        val coffees = apiService.getCoffeeList().coffee
        coffeeList = coffees
        Log.d("RepositoryImpl", "Coffee list loaded successfully: ${coffeeList?.size} items")
        return coffees
    }

    override fun getCoffeeDetail(id: Int): Coffee {
        val coffee = coffeeList?.find { it.id == id }
        if (coffee != null) {
            Log.d("RepositoryImpl", "Coffee with id $id found: $coffee")
            return coffee
        } else {
            Log.d("RepositoryImpl", "Coffee with id $id not found")
            throw NoSuchElementException("Coffee with id $id not found")
        }
    }
}