package com.atom.andreytomilovtestandroidvacc2024.data.network

import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import retrofit2.http.GET

interface ApiService {
    @GET("/462fb1fc-b4ad-44b1-ba51-3e54fde3154d")
    suspend fun getCoffeeList(): List<Coffee>

}