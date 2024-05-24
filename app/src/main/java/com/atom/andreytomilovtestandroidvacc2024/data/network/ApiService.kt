package com.atom.andreytomilovtestandroidvacc2024.data.network

import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.CoffeeDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v3/{mock_id_for_list}")
    suspend fun getCoffeeList(): List<Coffee>

    @GET("/v3/{mock_id_for_detail}")
    suspend fun getCoffeeDetail(@Path("coffee_id : Coffee") id: Int): CoffeeDetails
}