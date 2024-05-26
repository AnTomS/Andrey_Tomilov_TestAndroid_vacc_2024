package com.atom.andreytomilovtestandroidvacc2024.data.network

import com.atom.andreytomilovtestandroidvacc2024.domain.dto.CoffeeResponse
import retrofit2.http.GET

interface ApiService {
    @GET("fa3421a6-2eb8-4a4f-8589-388d464ea740")
    suspend fun getCoffeeList(): CoffeeResponse

}