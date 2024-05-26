package com.atom.andreytomilovtestandroidvacc2024.domain.repository

import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee

interface Repository {
    suspend fun getCoffees(): List<Coffee>
    fun getCoffeeDetail(id: Int): Coffee
}